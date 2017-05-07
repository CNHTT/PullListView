package com.cnh.bluetooth.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * 项目名称：0505Bluetooth.
 * 创建人： CT.
 * 创建时间: 2017/5/4.
 * GitHub:https://github.com/CNHTT
 */
public class ContextUtils {
    private static LayoutInflater inflater;
    public static View inflate(Context context, int res){
        if(inflater==null) {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res,null);
    }

    /**
     * 获取屏幕宽
     * @param context
     * @return
     */
    public static int getSreenWidth(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高
     * @param context
     * @return
     */
    public static int getSreenHeight(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }
}
