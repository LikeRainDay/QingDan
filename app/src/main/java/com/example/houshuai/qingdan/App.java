package com.example.houshuai.qingdan;

import android.app.Application;
import android.app.Notification;
import android.content.SharedPreferences;
import android.util.Log;

import com.umeng.socialize.PlatformConfig;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * 全局
 * Created by HouShuai on 2016/7/5.
 */

public class App extends Application {

    private List<String> mSelf = new ArrayList<>();
    public boolean mIsLogin;
    public String mID;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        initNotification();
        //判断是否登录
        checkIsLogin();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 开启debug会影响性能
    }

    public void checkIsLogin() {
        SharedPreferences isLogin = getSharedPreferences("IsLogin", MODE_PRIVATE);
        mIsLogin = isLogin.getBoolean("isLogin", false);
        mID = isLogin.getString("ID", "false");
        Log.e("login",mIsLogin+"---检查----"+mID);
    }


    public void setIsLoginSharedPreferences(boolean Login, String ID) {
        SharedPreferences isLogin = getSharedPreferences("IsLogin", MODE_PRIVATE);
        SharedPreferences.Editor edit = isLogin.edit();
        edit.putBoolean("isLogin", Login);
        edit.putString("ID", ID);
        edit.commit();
    }

    {
        //新浪微博
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //易信
        PlatformConfig.setSinaWeibo("3904149049", "0784d48305553b8b00d7079de43de979");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setPinterest("1439206");
    }

    private void initNotification() {
        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(getApplicationContext());
        builder.statusBarDrawable = R.drawable.jpush_notification_icon;
        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
        builder.notificationDefaults = Notification.DEFAULT_SOUND
                | Notification.DEFAULT_VIBRATE
                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
        JPushInterface.setPushNotificationBuilder(1, builder);
    }


    public List<String> getMySharePerference(String ID) {
        SharedPreferences sharedPreferences = getSharedPreferences(ID, MODE_PRIVATE);
        sharedPreferences.getString("name", "false");
        sharedPreferences.getString("pass", "false");
        sharedPreferences.getString("TouXiang", "false");
        sharedPreferences.getString("BackPic", "false");
        sharedPreferences.getString("self_name", "false");
        mSelf.add(sharedPreferences.getString("name", "false"));
        mSelf.add(sharedPreferences.getString("pass", "false"));
        mSelf.add(sharedPreferences.getString("TouXiang", "false"));
        mSelf.add(sharedPreferences.getString("BackPic", "false"));
        mSelf.add(sharedPreferences.getString("self_name", "未命名"));
        return mSelf;
    }

    public void setMySharePerference(String ID, String name, String pass, String TouXiang, String BackPic, String self_name) {
        if (mSelf != null) {
            mSelf.clear();
        }
        SharedPreferences sharedPreferences = getSharedPreferences(ID, MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        //账号
        edit.putString("name", name);
        //密码
        edit.putString("pass", pass);
        //头像
        edit.putString("TouXiang", TouXiang);
        //背景
        edit.putString("BackPic", BackPic);
        //用户名
        edit.putString("self_name", self_name);
        edit.commit();
    }

}
