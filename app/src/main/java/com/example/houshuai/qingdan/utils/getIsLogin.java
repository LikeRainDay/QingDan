package com.example.houshuai.qingdan.utils;

import android.app.Activity;

import com.example.houshuai.qingdan.App;

/**
 * Created by HouShuai on 2016/7/12.
 */

public class GetIsLogin {
    private Activity mActivity;
    private final App application;

    public GetIsLogin(Activity mActivity) {
        this.mActivity = mActivity;

        application = (App) mActivity.getApplication();
    }

    public boolean IsLogin() {
        application.checkIsLogin();
        boolean mIsLogin = application.mIsLogin;
        return mIsLogin;
    }


}
