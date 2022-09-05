package com.example.logutils;

import android.util.Log;

/**
 * 控制日志的打印行为,比如让level等于BERBOSE就可以把所有的日志都打印出来,
 * 让level等于WARN就可以只打印警告以上级别的日志
 * 让level等于NOTHING就可以把所有日志都屏蔽掉
 */
public class LogUtil {
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static int level = VERBOSE;

    public static void v(String tag,String msg){
        if(level<= VERBOSE){
            Log.v(tag,msg);
        }
    }

    public static void d(String tag,String msg){
        if(level<= DEBUG){
            Log.d(tag,msg);
        }
    }

    public static void i(String tag,String msg){
        if(level<= INFO){
            Log.i(tag,msg);
        }
    }

    public static void w(String tag,String msg){
        if(level<= WARN){
            Log.w(tag,msg);
        }
    }

    public static void e(String tag,String msg){
        if(level<= ERROR){
            Log.e(tag,msg);
        }
    }
}
