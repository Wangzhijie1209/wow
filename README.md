布局:
LinearLayout(线性布局):
android:orientation="vertical 或 horizontal" vertical是纵向排列 horizontal是水平排列 默认是水平的
gravity:控制组件所包含的子元素的对其方式,可多个组合
layout_gravity:控制该组件在父容器里的对齐方式
background:为该组件设置一个背景图片,或者是用颜色覆盖
divider:分割线
showDividers:设置分割线所在的位置,none(无),beginning(开始)、end(结束)、middle(每两个组件中间)
dividerPadding:设置分割线的padding
layout_weight(权重):该属性是用来等比例的划分区域

    RelativeLayout(相对布局)
    1.基本属性:
        gravity 设置容器内组件的对齐方式
        ignoreGravity : 设置了该属性为true的属性的组件,将不受gravity属性的影响
    2.根据父容器定位:
        layout_alignParentLeft : 左对齐
        layout_alignParentRight : 右对齐
        layout_alignParentTop : 顶部对齐
        layout_alignParentBottom : 底部对齐
        android:layout_centerHorizontal : 水平居中
        android:layout_centerVertical : 垂直居中
        android:layout_centerInParent : 中间位置
    3.根据兄弟组件定位 兄弟组件:就是处于同一层次容器的组件
        layout_toLeftOf : 参考组件的左边
        layout_toRightOf : 参考组件的右边
        layout_above : 参考组件的上方
        layout_below : 参考组件的下方
        layout_alignTop : 对齐参考组件的上边界
        layout_alignBottom : 对齐参考组件的下边界
        layout_alignLeft : 对齐参考组件的左边界
        layout_alignRight : 对齐参考组件的右边界
    4.margin(偏移)
        设置组件与父容器的边距,又叫偏移
        layout_margin : 设置组件上下左右的偏移量
        layout_marginLeft : 设置组件左边的偏移量
        layout_marginRight : 设置组件右边的偏移量
        layout_marginTop : 设置组件上面的偏移量
        layout_marginBottom : 设置组件离下边的偏移量
    5.padding(填充)
        设置组件内部元素间的边距(比如TextView里的字体位置)
        android:padding : 往内部元素的上下左右填充一定边距
        android:paddingLeft : 往内部元素的左边填充一定边距
        android:paddingRight : 往内部元素的右边填充一定边距
        android:paddingTop : 往内部元素的上方填充一定边距
        android:paddingBottom : 往内部元素的下方填充一定边距
margin和padding的区别:
margin代表的是偏移,比如:marginleft="5dp" 表示组件离容器左边缘偏移5dp
padding代表的是填充,而填充的对象针对的是组件中的元素,比如TextView中的文字,比如:为TextView设置paddingleft="5dp",则是在组件里的
元素的左边填充5dp的空间。
margin针对的是容器中的组件,而padding针对的是组件中的元素。
4.margin(偏移)设置组件与父容器的边距,又叫偏移

    TableLayout(表格布局)
    1.确定表格的行数,使用属性来设置每一行中的第某列的元素隐藏,拉伸,或者收缩即可
    2.TableLayout使用网格的方式来排列组件,就是行与列的方式
    3.如何确定行数与列数
        1.如果我们直接往TableLayout中添加组件的话,那么这个组件将占满一行
        2.如果我们想一行上有多个组件的话,就要添加一个TableRow的容器,把组件都丢到里面
        3.tablerow中的组件个数就决定了该行有多少列,而列的宽度由该列中最宽的单元格决定
        4.tablerow的layout_width属性,默认是fill_parent的,我们自己设置成其他的值也不会生效,但是layout_height默认是wrapten-centent的,
            我们却可以自己设置大小
        5.整个表格布局的宽度取决于父容器的宽度(占满父容器本身)
        6.有多少行就要自己数了,一个tablerow一行,一个单独的组件也一行 多少列则是看tableRow中的组件个数,组件最多的就是TableLayout的列数
    4.三个常用属性
        android:collapseColumns:设置需要被隐藏的列的序列号
        android:shrinkColumns:设置允许被收缩的列的序列号
        android:stretchColumns:设置运行被拉伸的列的序列号
        以上这三个属性的列号都是从0开始算的,比如 shrinkColunmns="2" ,对应的是第三列
        可以设置多个,用逗号隔开,比如"0,2",如果是所有列都生效,则用 "*"号即可
        除了这三个常用属性,还有两个属性,分别就是跳格子以及合并单元格,这和HTML中的Table类似
        
        android:layout_column="2" : 表示的就是跳过第二个,直接显示到第三个格子处,从1开始算的
        android:layout_span="4" : 表示合并4个单元格,也就说这个组件占4个单元格

    FrameLayout(帧布局):从父容器的左上角开始绘制,后面的组件叠放在之前的组件上面。
        常见属性:
            android:foreground : 设置前景
            android:foregroundGravity : 设置前景位置
            通过前景可以在帧布局中插入图片或纯色填充,foregroundGravity则是控制图片放置的位置,一个插入图片作为前景并将其置于右下角

    GridLayout(网格布局):
        可以自己设置布局中组件的排列方式
        可以自定义网格布局有多少行,多少列
        可以直接设置组件位于某行某列
        可以设置组件横跨几行或几列
       GridLayout属性:
        android:columnCount : 最大列数
        android:rowConunt : 最大行数
        android:orientation : GridLayout中子元素的布局方向
        android:alignmentMode : alignBounds:对齐子视图边界 alignMargins:对齐子视距内容,默认值
        android:columnOrderPreserved : 使列边界显示的顺序和列索引的顺序相同,默认是true
        android:rowOrderPreserved : 使行边界显示的顺序和行索引的顺序相同,默认是true
        android:useDefaultMargins : 没有指定视图的布局参数时使用默认的边距,默认值是false

        子元素属性:
        android:layout_column  指定该单元格在第几列显示
        android:layout_row  指定该单元格在第几行显示
        android:layout_columnSpan  指定该单元格占据的列数
        android:layout_rowSpan   指定该单元格占据的行数
        android:layout_gravity  指定该单元格在容器中的位置
        android:layout_coumnWeight  (API21加入)列权重
        android:layout_rowWeight  (API21加入)行权重

Android中 px dpi dp等单位的含义

px:像素单位,没有固定长度的,不同设备上单位像素色块的大小是不一样的,常常说的手机显示1080*1920的单位就是像素,一个像素点就是1px,
我们常说的某个手机是1080*1920的像素指的是屏幕的宽排列着1080个像素点,高排列着1920个像素点,那相同长度的手机,排列的像素点越
多肯定表现出来的画面越细腻
尺寸面积大小相同的两块屏幕,分辨率大小可以是不一样的,分辨率高的屏幕上像素点(色块)就多,所以屏幕内可以展示的画面就更细致,单个色块
面积更小。而分辨率低的屏幕上像素点(色块)更少,单个像素面积更大,可以显示的画面就没那么细致
作为图像构成的基本单元,单个像素的大小并不固定,跟随屏幕大小和像素数量的关系变化(屏幕越大,像素越低,单个像素越大,反之亦然).所以在使用
像素作为设计单位时,在不同的设备上可能会有缩放或拉伸的情况

ppi:屏幕密度(Pixels Per Inch)，意思是每英寸(1英寸约等于2.54cm)所拥有的像素数量。因此ppi数值越高,说明屏幕能以更高的密度来显示对应
图像效果,其细节自然就更加丰富,效果更高

dpi:这是一个密度单位,指的是每英寸屏幕内有多少个像素点,这个值也是评判手机展示程度的一个重要单位,例如一个手机的dpi为400,
那么就表示这个手机1英寸屏幕内有400个像素点  
dpi=ppi
计算公式:长度像素的平方 + 宽度像素的平方的和 开平方,除以尺寸(屏幕对角线英寸)
例如:手机分辨率为1920x1080 屏幕尺寸为5寸,对应ppi则为440


density(密度):density在每个设备上都是固定的,DPI/160=density,屏幕的总px宽度/density=屏幕的总dp宽度
与dpi类似,dpi表示1英寸上对应有多少个像素(对应屏幕物理像素密度),而density则表示1dp上有多少个像素,可以理解为dp密度(对应抽象的屏幕密度),它可以用于dp和px之间转换
计算公式:density = px/dp;
它与dpi之间的关系是固定的:density =dpi/160
例如:当dpi=160时,density=1,也就是1英寸上有160个像素,1dp就代表1像素
当dpi=320时,density=2,也就是1英寸上有320个像素,1dp就代表2像素
为什么用dpi作为标准？
1.Android主流设备的dpi有:120dpi、160dpi、240dpi、320dpi、440dpi、480dpi、在开发过程中,因为需要对多个主流设备尺寸适配,在以某个dpi标准设计好后,需要转换成其他主流dpi尺寸,
上面主流dpi他们分别是160的0.75、 1、 1.5、 2、 2.75 、3倍,也就是他们倍数是有限小数

dp:dp是Android开发中常用的长度单位,为了适配不同屏幕设备而定义的一种抽象单位,1dp可以理解为屏幕上的一个点,这个点在不同屏幕分辨率上占用的
像素不一样,比如在屏幕分辨率高的设备上占用更多像素,在分辨率小的设备上占用更少的像素,从而让他整体上来看显示的比例相对屏幕大小是一样的
dp会根据不同的dpi和px来决定dp真实的长度,有一个公式
px=dp*(dpi/160)
dp=px/(dpi/160)
density = dpi / 160
1dp=1dip 为了与字体的sp同一
dp是物理尺寸是不会变的(就像是英寸、厘米这些),在不同屏幕密度下,1dp的物理长度也相同

android的drawable和mipmap文件夹该怎么用
mipmap只用来放图标
密度          建议尺寸
mdpi         48*48
hdpi         72*72
xhdpi        96*96
xxhdpi       144*144
xxxhdpi      192*192
为了适配各个版本的系统,一般使用Image Asset Studio生成

drawable文件夹
drawable里放资源图片,那对于ui给的一倍图,二倍图怎么放? ui一般以320x640为标准原型,给出一二三倍图根据dp和px的关系存放即可,
如果ui以1080x1920切的图,怎么放?
这个更多大的分辨率没关系,它只要给的一倍图,放在mdpi里就行,因为这里1dp=1px，1px就可以表示原大小,整体效果都是根据1080x1920走的,
所以要大都大,要小都小

密度                dpi范围       dp与px关系(手机通用匹配,不包含全部)
ldpi(低)           ~120dpi       (0.75) 1dp = 0.5px
mdpi(中)           ~160dpi       (1.0) 1dp = 1px
hdpi(高)           ~240dpi       (1.5) 1dp = 1.5px
xhdpi(超高)        ~320dpi       (2.0) 1dp = 2px
xxhdpi(超超高)     ~480dpi       (3.0) 1dp = 3px
xxxhdpi(超超超高)  ~640dpi        (4) 1dp = 4px


图片文件夹       分辨率
drawable_ldpi   240x320
drawable_mdpi   320x480
drawable_hdpi   480x800
drawable_xhdpi   720x1280
drawable_xxhdpi   1080x1920
drawable_xxxhdpi   1440x2560

mipmap文件夹:(只用来放图标)
密度              建议尺寸
mdpi             48*48
hdpi             72*72
xhdpi            96*96
xxhdpi           144*144
xxxhdpi          192*192


开发小技巧:
全局获取Context的技巧:
1.首先创建一个自己的MyApplication,继承自Application 然后重写父类的onCreate()方法
2.定义一个Context
3.通过调用getApplicationContext()方法得到了一个应用程序级别的Context
4.提供一个静态的getContext()方法 在这里将刚才获取到的Context进行返回
5.在AndroidManifest.xml文件的 <application>标签下 初始化该类

使用Intent传递对象
Serializable(序列化)方式: 表示将一个对象转换成可存储或可传输的状态,序列化后的对象可以在网络上进行传输,也可以存储到本地
使用方式:只需要让一个类去实现Serializable这个接口就可以了  移步到 Person 类查看示例

多窗口模式:将A B 两个项目运行到手机上然后启动A程序,这时logcat中的打印日志为 A:onCreate onStart onResume 三个方法会
依次得到执行 
然后进入到多窗口模式: 这时会执行:onPause onStop onDestroy onCreate onStart onResume onPause
你会发现,A项目中的Activity经历了一个重新创建的过程,其实这个是正常现象,因为进入多窗口模式后活动的大小发生了比较大的变化,
此时默认是会重新创建活动的.除此之外,像横竖屏切换也是会重新创建活动的,紧接着进入多窗口模式A项目会变成暂停状态onPause
然后选中B项目,此时 onCreate onStart onResume 方法依次得到了执行,说明现在B项目变成了运行状态。
接下来我们可以随意操作一下A项目, 那么B项目会先执行onPause()方法,A项目onResume()方法得到了执行

在多窗口模式下,用户仍然可以看到处于暂停状态的应用,像视频播放器之类的应用在此时就应该能继续播放视频才对.因此,我们最好不要在
活动的onPause()中去处理视频播放器的暂停逻辑,而是应该在哦那Stop()方法中去处理,并且在onStart()方法恢复视频的播放

针对进入多窗口模式时活动会被重新创建,如果想要改变这一默认行为,可以在AndroidManifest.xml中对活动进行配置:
android:configChanges="orientation|keyboardHidden|screenSize|screenLayout"
加入这行配置之后,不管是进入到多窗口模式,还是横竖屏切换,活动都不会被重新创建,而是会将屏幕发生变化的事件通知
到Activity的onConfigurationChanged()方法当中,因此 如果你像在屏幕发生变化的时候进行相应的逻辑处理,
那么在活动中重写onConfigurationChanged()方法即可

禁用多窗口模式:
如果不希望自己的应用能够在多窗口模式下运行,那么就可以把这个功能关闭掉,只需要在AndroidManifest.xml的<application>或
<activity>标签中加入如下属性即可:
android:resizeableActivity=["true" | "false"]
其中,true表示应用支持多窗口模式,false表示应用不支持多窗口模式,如果不配置这个属性,那么默认值为true
虽然android:resizeableActivity=["true" | "false"] 这个属性的用法很简单,但是它还存在着一个问题,就是这个属性只有
当项目的tagetSdkVersion指定成24或者更高的时候才有用,否则这个属性是无效的,
针对这种情况,还有一种解决方案:Android规定,如果项目指定的targetSdkVersion低于24,并且活动是不允许横竖屏切换的,那么
该应用也将不支持多窗口模式.默认情况下,我们的应用都是可以随着手机的旋转自由的横竖屏切换的,如果想要让应用不允许横竖屏切换,
那么就需要在AndroidManifest.xml的<activity>标签中加入如下配置:
android:screenOrientation=["portrait" | "landscape"] 其中 portrait表示活动只支持竖屏,landscape表示活动只
支持横屏 只要我们将screenOrientation设置为portrait 说明我们已经成功禁用多窗口模式了




       