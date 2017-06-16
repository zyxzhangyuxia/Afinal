package com.scky.demo_afinal.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.scky.demo_afinal.R;
import com.scky.demo_afinal.presenter.BrowserUtils;
import com.scky.demo_afinal.presenter.KLog;
import com.scky.demo_afinal.presenter.QrUtils;
import com.scky.demo_afinal.zxing.activity.CaptureActivity;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * Afinal-FinalActivity使用
 * 不使用findViewById和setonClickListener，使用注解的方式绑定UI和事件
 */

public class MainActivity extends FinalActivity {

    private final String qr_url = "https://www.baidu.com";
    private final int REQUESTCODE = 1;

    @ViewInject(id = R.id.btn_finalActivity,click = "btn_finalActivityClick")
    Button btn_finalActivity;

    @ViewInject(id = R.id.btn_create_qr,click = "btn_finalActivityClick")
    Button btn_create_qr;

    @ViewInject(id = R.id.btn_scan_qr,click = "btn_finalActivityClick")
    Button btn_scan_qr;

    @ViewInject(id = R.id.iv_qr)
    ImageView iv_qr;

    @ViewInject(id = R.id.text_scan_result)
    TextView text_scan_result;

    QrUtils mQrUtils;
    BrowserUtils browserUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KLog.print("onCreate");
        initVail();
    }

    public void btn_finalActivityClick(View view){
        switch (view.getId()){
            case R.id.btn_finalActivity:
                KLog.D("btn_finalActivityClick"+"测试 成功");
                btn_finalActivity.setText("测试 成功");
                break;
            case R.id.btn_create_qr:
                KLog.D("btn_finalActivityClick"+"生成二维码");
                getQrBitmap();
                break;
            case R.id.btn_scan_qr:
                KLog.D("btn_finalActivityClick"+"扫描二维码");
                iv_qr.setVisibility(View.GONE);
                Intent intent = new Intent(this, CaptureActivity.class);
                startActivityForResult(intent,REQUESTCODE);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        KLog.D("onActivityResult");
        if(data != null){
            Bundle bundle = data.getExtras();
            if(bundle != null){
                String resultData = data.getStringExtra("result");
                text_scan_result.setText(resultData);
                KLog.D("resultCode = "+resultData);
                //根据扫描到的结果打开链接
                 browserUtils.openUrl(this,resultData);
            }
        }
    }

    /**
     * 变量初始化
     */
    private void initVail(){
        mQrUtils = QrUtils.getInstance();
        browserUtils = BrowserUtils.getInstance();
    }

    /**
     * 获取二维码图片并显示在ImageView上
     */
    private void getQrBitmap(){
        final Bitmap qrBmp = mQrUtils.createQr(qr_url);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                iv_qr.setVisibility(View.VISIBLE);
                iv_qr.setImageBitmap(qrBmp);
            }
        });
    }

}
