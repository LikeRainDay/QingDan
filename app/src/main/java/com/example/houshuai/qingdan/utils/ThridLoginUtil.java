package com.example.houshuai.qingdan.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.WelcomeActivity;
import com.example.houshuai.qingdan.UI.Custom.PopMenu;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItem;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItemListener;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * 第三方登录工具类
 * <p>
 * Created by HouShuai on 2016/7/10.
 */

public class ThridLoginUtil {
    private static SHARE_MEDIA platform = null;
    private static boolean isAuth = false;
    private static Context mContext;
    private static UMShareAPI umShareAPI;

    public static UMShareAPI startAuto(final Activity activity) {
        //社会化登录
        mContext = activity;
        umShareAPI = UMShareAPI.get(activity);


        PopMenu mPopMenu = new PopMenu.Builder().attachToActivity(activity)
                .addMenuItem(new PopMenuItem("QQ", activity.getResources().getDrawable(R.mipmap.umeng_socialize_qq_on)))
                .addMenuItem(new PopMenuItem("新浪", activity.getResources().getDrawable(R.mipmap.umeng_socialize_sina_on)))
                .addMenuItem(new PopMenuItem("人人", activity.getResources().getDrawable(R.mipmap.umeng_socialize_renren_on)))
                .setOnItemClickListener(new PopMenuItemListener() {
                    @Override
                    public void onItemClick(PopMenu popMenu, int position) {
                        switch (position) {
                            case 0:
                                //QQ
                                platform = SHARE_MEDIA.QQ;

                                break;
                            case 1:
                                //新浪
                                platform = SHARE_MEDIA.SINA;

                                break;
                            case 2:
                                //人人
                                platform = SHARE_MEDIA.RENREN;

                                break;
                        }

                        if (!isAuth) {
                            //取消授权
                            umShareAPI.deleteOauth(activity, platform, umdelAuthListener);
                            isAuth = true;
                            return;
                        }
                        umShareAPI.doOauthVerify(activity, platform, umAuthListener);
                        isAuth = false;

                    }
                })
                .build();
        if (!mPopMenu.isShowing()) {
            mPopMenu.show();
        }
        return umShareAPI;
    }

    /**
     * auth callback interface
     **/
    private static UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(mContext, " 清除授权", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "取消授权", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * auth callback interface
     **/
    private static UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(mContext, " 授权成功", Toast.LENGTH_SHORT).show();
            //授权
            umShareAPI.getPlatformInfo((Activity) mContext, platform, umGetfriendListener);
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "取消授权", Toast.LENGTH_SHORT).show();
        }
    };


    private static UMAuthListener umGetfriendListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null) {
                com.umeng.socialize.utils.Log.d("auth callbacl", "getting data");
                String screen_name = data.get("screen_name");
                String profile_image_url = data.get("profile_image_url");
                String openid = data.get("openid");
                App application = (App) ((Activity) mContext).getApplication();
                application.setIsLoginSharedPreferences(true, openid);
                application.setMySharePerference(openid, "third", openid, profile_image_url, "", screen_name);

                Intent intent = new Intent(mContext, WelcomeActivity.class);
                mContext.startActivity(intent);
                ((Activity) mContext).finish();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(mContext, "get fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(mContext, "get cancel", Toast.LENGTH_SHORT).show();
        }
    };

}
