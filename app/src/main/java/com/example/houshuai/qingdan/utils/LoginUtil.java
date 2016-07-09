package com.example.houshuai.qingdan.utils;

import com.example.houshuai.qingdan.App;

import java.util.List;

/**
 * Created by HouShuai on 2016/7/9.
 */

public class LoginUtil {

    private static App mInstance;
    private static boolean mIsLogin;
    private static String mID;
    private static List<String> mSelfcontent;

    public LoginUtil(App mAPP) {
        this.mInstance = mAPP;
    }

    //是否登录
    public static boolean islogin(String id) {
        List<String> mySharePerference = mInstance.getMySharePerference(id);
        mSelfcontent = mySharePerference;
        return id.equals(mySharePerference.get(0));
    }

    //账号密码是否一致
    public static boolean nameEqualPass(String name, String pass) {
        List<String> mySharePerference = mInstance.getMySharePerference(name);
        if (name.equals(mySharePerference.get(0)) && pass.equals(mySharePerference.get(1))) {
            return true;
        }
        return false;
    }


}
