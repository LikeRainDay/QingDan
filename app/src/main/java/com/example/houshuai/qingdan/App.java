package com.example.houshuai.qingdan;

import android.app.Application;
import android.app.Notification;

import com.example.houshuai.qingdan.Receive.MyReceiver;

import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

import static com.example.houshuai.qingdan.Receive.MessageReceiver.MESSAGE_RECEIVED_ACTION;

/**
 * 全局
 * Created by HouShuai on 2016/7/5.
 */

public class App extends Application {


    private MyReceiver  mReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        initNotification();
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

}
