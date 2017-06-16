package com.scky.demo_afinal.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.scky.demo_afinal.presenter.KLog;

/**
 * Created by zyx on 2017/6/15.
 * 自定义SurfaceView
 */

public class XSurfaceView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder;

    public XSurfaceView(Context context) {
        this(context,null);
    }

    public XSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public XSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        surfaceHolder = getHolder();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        KLog.print("surface第一次创建,在该函数中做绘制界面相关的初始化工作,一般情况下在另外的线程中绘制界面");
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        KLog.print("当surface的状态（大小和格式）发生变化之后调用该函数，create之后至少会被调用一次");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        KLog.print("销毁surface时调用，调用之后不能再使用该surface了，所以，该函数主要做一些资源清理的工作");
    }
}
