package com.example.houshuai.qingdan.UI.Activity;


import android.content.Intent;
import android.os.SystemClock;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.utils.LoginUtil;

public class WelcomeActivity extends BaseActivity {
    @Override
    protected void initLayout() {
        LoginUtil.windowSettings(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2500);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                        finish();
                    }
                });
            }
        }).start();
    }



    @Override
    protected int getActivityID() {
        return R.layout.welcom;
    }
}