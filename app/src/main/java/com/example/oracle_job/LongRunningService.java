package com.example.oracle_job;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import androidx.annotation.Nullable;

/**
 * 创建定时任务:
 * Android中的定时任务一般有两种实现方式,一种是使用Java API里提供的Timer类,一种是使用Android的Alarm机制。这两种方式在多数情况下都能
 * 实现类似的效果。但Timer有一个明显的短板,它并不太适用于那些需要长期在后台运行的定时任务。我们都知道,为了能让电池更加耐用,每种手机都会有
 * 自己的休眠策略,Android手机就会在长时间不操作的情况下自动让CPU进入到睡眠功能,这就有可能导致Timer中的定时任务无法正常运行。而Alarm则
 * 具有唤醒CPU的功能,它可以保证在大多数情况下需要指定定时任务的时候CPU都能正常工作。需要注意,这里唤醒CPU和唤醒屏幕完全不是一个概念,
 * 千万不要产生混淆
 *
 * Alarm机制:
 * 主要就是借助了AlarmManager类来实现的.这个类和NotificationManager有点类似,都是通过掉欧阳那个Context的getSystemService()方法
 * 来获取实例的,只是这里需要传入的参数是Context.ALARM_SERVICE.因此获取一个AlarmManager的实例就可以写成:
 * AlarmManager manager =(AlarmManager) getSystemService(Context.ALARM_SERVICE);
 * 接下来接下来调用AlarmManager的set()方法就可以设置一个定时任务了,比如想要设定一个任务在10秒钟后执行,就可以写成:
 * long triggerAtTime = SystemClock.elapsedRealtime() + 10 * 1000;
 * manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pendingIntent);
 * set()方法中需要传入的3个参数稍微有点复杂,
 * 第一个参数:是一个整形参数,用于指定AlarmManager的工作类型,有四种值可选,分别是:ELAPSED_REALTIME   ELAPSED_REALTIME_WAKEUP RTC
 * 和 RTC_WAKEUP
 * 其中ELAPSED_REALTIME:表示让定时任务的触发时间从系统开机开始算起,但不会唤醒CPU
 * ELAPSED_REALTIME_WAKEUP:同样表示让定时任务的触发时间从系统开机开始算起,但会唤醒CPU
 * RTC:表示让定时任务的触发时间从1970年1月1日0点开始算起,但不会唤醒CPU
 * RTC_WAKEUP:同样表示让定时任务的触发时间从1970年1月1日0点开始算起,但会唤醒CPU
 * 使用SystemClock.elapsedRealtime()方法可以获取到系统开机至今所经历时间的毫秒数,
 * 使用System.currentTimeMillis()方法可以获取到1970年1月1日0点至今所经历时间的毫秒数
 *
 * 第二个参数:定时任务触发的时间,以毫秒为单位. 如果第一个参数使用的是ELAPSED_REALTIME 或 ELAPSED_REALTIME_WAKEUP,则这里传入
 * 开机至今的时间再加上延迟执行的时间.
 * 如果第一个参数使用的是RTC或RTC_WAKEUP 则这里传入1970年1月1日0点至今的时间再加上延迟执行的时间
 *
 * 第三个参数是一个PendingIntent, 这里一般会调用getService()方法或者getBroadcast()方法来获取一个能够执行服务或广播的PendingIntent
 * 这样但定时任务被触发的时候,服务的onStartCommand()方法或广播接收器的onReceive()方法就可以得到执行
 *
 * 设定一个任务在十秒钟后进行
 * long triggerAtTime = System.currentTimeMillis() + 10 * 1000;
 * manager.set(AlarmManager.RTC_WAKEUP,triggerAtTime,pendingIntent);
 *
 * 在想启动服务的时候调用如下代码:
 * Intent intent = new Intent(context,LongRunningService.class);
 * context.startService(intent);
 *
 * 另外需要注意的是,从Android4.4系统开始,Alarm任务的触发时间将会变得不准确,有可能会延迟一段时间后任务才能得到执行.
 * 这并不是个bug,而是系统在耗电性方面进行的优化,系统会自动检测目前有多少Alarm任务存在,然后将触发时间相近的几个任务
 * 放在一起执行,这就可大幅度的减少CPU被唤醒的次数,从而有效延长电池的使用时间
 *
 * 如果你要求Alarm任务的执行时间必需准确无误,Android仍然提供了解决方案,使用AlarmManager的setExact()方法来替代set()方法,
 * 就基本上可以保证任务能够准确执行了
 *
 * Doze模式:在android6.0系统中,谷歌加入了一个全新的Doze模式,从而可以极大幅度地延长电池使用寿命。
 * 但用户的设备是Android6.0或以上系统时,如果该设备未插接电源,处于静止状态(Android7.0中删除了这一条件),且屏幕关闭了一段时间
 * 之后,就会进入到Doze模式.在Doze模式下,系统会对CPU，网络、Alarm等活动进行限制,从而延长了电池的使用寿命。当然,系统并不会一直
 * 处于Doze模式,而是会间歇性地退出Doze模式一小段时间,在这段时间中,应用就可以去完成他们的同步操作,Alarm任务等.
 * 随着设备进入Doze模式的时间越长,间歇性地退出Doze模式的时间间隔也会越长.因为如果设备长时间不使用的话,是没必要频繁退出Doze模式
 * 来执行同步操作的。
 * 在Doze模式下有哪些功能会收到限制?
 * 网络访问被禁止
 * 系统忽略唤醒CPU或者屏幕操作
 * 系统不再执行WIFI扫描
 * 系统不再执行同步服务
 * Alarm任务将会在下次退出Doze模式的时候执行:也就是说,在Doze模式下,我们的Alarm任务将会变得不准时。当然,这在大多数情况下都是
 * 合理的,因为只有当用户长时间不适用手机的时候才会进入Doze模式,通常在这种情况下对Alarm任务的准时性要求并没有那么高
 * 如果有特殊的需求,要求Alarm任务即使在Doze模式下也必须正常执行,Android还是提供了解决方案.调用AlarmManager的setAndAllowWhileIdle()
 * 或 setExactAndAllowWhileIdle()方法就能让定时任务即使在Doze模式下也能正常执行了,这两个方法的区别和set() setExact()方法之间的区别是一样的
 *
 *
 */
//实现一个长时间在后台定时运行的服务
public class LongRunningService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //在这里执行具体的逻辑操作
            }
        }).start();
        //获取AlarmManager的实例
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //定义任务的触发时间为1小时
        int anHour = 60*60 *1000;//这是一小时的毫秒数
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        //使用PendingIntent指定处理定时任务的服务为LongRunningService.class
        Intent i = new Intent(this, LongRunningService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, i, 0);
        //调用set方法完成设定
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }
}
