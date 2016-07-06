package com.example.houshuai.qingdan.UI.Activity;


import android.content.Intent;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
public class WelcomeActivity extends BaseActivity{
    @Override
    protected void initLayout() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
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