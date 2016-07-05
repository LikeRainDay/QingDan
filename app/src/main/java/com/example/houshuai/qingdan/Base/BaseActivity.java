package com.example.houshuai.qingdan.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类
 * Created by HouShuai on 2016/7/5.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityID());
        bind = ButterKnife.bind(this);
        initLayout();
    }
    protected abstract void initLayout();
    protected abstract int getActivityID();
}
