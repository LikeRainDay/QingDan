package com.example.houshuai.qingdan;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * 全局
 * Created by HouShuai on 2016/7/5.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


    }
    {
        //新浪微博
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //易信
        PlatformConfig.setSinaWeibo("3904149049", "0784d48305553b8b00d7079de43de979");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setPinterest("1439206");
    }
}
