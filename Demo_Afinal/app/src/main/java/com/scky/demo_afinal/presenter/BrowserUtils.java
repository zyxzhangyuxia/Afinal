package com.scky.demo_afinal.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by zyx on 2017/6/16.
 */

public class BrowserUtils {
    static BrowserUtils browserUtils;
    private BrowserUtils(){}

    public static BrowserUtils getInstance(){
        if(browserUtils == null){
            browserUtils = new BrowserUtils();
        }
        return  browserUtils;
    }

    /**
     * 打开一个URL地址
     * @param context
     * @param url
     */
    public void openUrl(Context context,String url){
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        context.startActivity(it);
    }

    /**
     * 打开本地链接
     * @param context
     * @param url
     */
    public void openLocalUrl(Context context,String url){
        Intent intent=new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri CONTENT_URI_BROWSERS = Uri.parse(url);
        intent.setData(CONTENT_URI_BROWSERS);
        intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
        context.startActivity(intent);
    }

}
