package com.scky.demo_afinal.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scky.demo_afinal.R;
import com.scky.demo_afinal.utils.KLog;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * Afinal-FinalActivity使用
 * 不使用findViewById和setonClickListener，使用注解的方式绑定UI和事件
 */

public class MainActivity extends FinalActivity {

    @ViewInject(id = R.id.btn_finalActivity,click = "btn_finalActivityClick")
    Button btn_finalActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KLog.print("onCreate");
    }

    public void btn_finalActivityClick(View view){
        KLog.D("btn_finalActivityClick"+"测试 成功");
        btn_finalActivity.setText("测试 成功");
    }


}
