package com.scky.demo_afinal.presenter;

import android.util.Log;

/**
 * Created by zyx on 2017/6/13.
 * 自定义Log类
 */

public class KLog {
    private static final String TAG = "lcs";

    public static void D(String logStr){
        Log.d(TAG,logStr);
    }

    public static void E(String logStr){
        Log.e(TAG,logStr);
    }

    public static void V(String logStr){
        Log.v(TAG,logStr);
    }

    public static void I(String logStr){
        Log.i(TAG,logStr);
    }

    public static void print(String logStr){
        Log.println(Log.DEBUG,TAG,logStr);
    }
}
