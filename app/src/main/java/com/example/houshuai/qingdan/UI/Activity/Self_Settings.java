package com.example.houshuai.qingdan.UI.Activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.MoreWindow;
import com.example.houshuai.qingdan.utils.LoginUtil;

import butterknife.BindView;

/**
 * Created by HouShuai on 2016/7/8.
 */

public class Self_Settings extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.self_settings_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.self_GeRen)
    LinearLayout mTself_GeRen;
    @BindView(R.id.self_XiuGaiPass)
    LinearLayout mself_XiuGaiPass;
    @BindView(R.id.self_TongZhi)
    LinearLayout mself_TongZhi;
    @BindView(R.id.self_CleanCaches)
    LinearLayout mself_CleanCaches;
    @BindView(R.id.settings_caches)
    TextView msettings_caches;
    @BindView(R.id.self_GuanYv)
    LinearLayout mself_GuanYv;
    @BindView(R.id.self_ShareApp)
    LinearLayout mself_ShareApp;
    @BindView(R.id.self_YiJianFanKu)
    LinearLayout mself_YiJianFanKu;
    @BindView(R.id.self_settings_button)
    Button mself_settings_button;
    private App application;
    private MoreWindow mMoreWindow;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.self_GeRen:
                break;
            case R.id.self_XiuGaiPass:
                break;
            case R.id.self_TongZhi:
                break;
            case R.id.self_CleanCaches:
                break;
            case R.id.settings_caches:
                break;
            case R.id.self_GuanYv:
                break;
            case R.id.self_ShareApp:
                if (null == mMoreWindow) {
                    mMoreWindow = new MoreWindow(this);
                    mMoreWindow.init();
                }
                mMoreWindow.showMoreWindow(view, 100);
                break;
            case R.id.self_YiJianFanKu:
                break;
            case R.id.self_settings_button:
                //退出登录
                application.setIsLoginSharedPreferences(false, application.mID);
                application.checkIsLogin();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("settings", true);
                startActivity(intent);
                finish();
                break;

        }
    }
    @Override
    protected void initLayout() {
        LoginUtil.windowSettings(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        addListener();
        application = (App) getApplication();
    }

    private void addListener() {
        mTself_GeRen.setOnClickListener(this);
        mself_XiuGaiPass.setOnClickListener(this);
        mself_TongZhi.setOnClickListener(this);
        mself_CleanCaches.setOnClickListener(this);
        msettings_caches.setOnClickListener(this);
        mself_GuanYv.setOnClickListener(this);
        mself_ShareApp.setOnClickListener(this);
        mself_YiJianFanKu.setOnClickListener(this);
        mself_settings_button.setOnClickListener(this);
    }

    @Override
    protected int getActivityID() {
        return R.layout.self_settings;
    }


}
