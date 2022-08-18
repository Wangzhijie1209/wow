package com.example.myapplication.chat.utils;

import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class Hide {
    private static final Hide myHide = new Hide();

    public static Hide getInstance() {
        return myHide;
    }

    //根据EditText所在坐标和用户点击的坐标相对比,判断是否隐藏键盘,因为当用户点击EditText时没必要隐藏
    public boolean isShowIdHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                //点击EditText的事件,忽略他
                return false;
            } else {
                return true;
            }
        }
        //如果焦点不是EditText则忽略,这个发生在视图刚绘制完,第一个焦点不再EditView上,和用户用轨迹球选择其他的焦点
        return false;
    }
    //多种隐藏软键盘方法的其中一种
    public void hideSoftInput(IBinder token, Context context){
        if(token != null){
            InputMethodManager im = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,InputMethodManager.HIDE_NOT_ALWAYS);

        }
    }
}
