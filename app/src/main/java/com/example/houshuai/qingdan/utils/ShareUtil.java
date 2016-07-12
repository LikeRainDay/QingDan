package com.example.houshuai.qingdan.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.PopMenu;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItem;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItemListener;
import com.example.houshuai.qingdan.inter.onSetShareDataInter;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

/**
 * 分享工具类
 * <p>
 * Created by HouShuai on 2016/7/10.
 */

public class ShareUtil implements onSetShareDataInter {


    private static Bundle mbundle;
    private onSetShareDataInter setShareDataInter;

    @Override
    public void shareDataToShare(Bundle bundle) {
        mbundle = bundle;
    }


    private static Context mContext;

    public static void startAuto(final Activity activity,Bundle bundle) {
        //社会化登录
        mContext = activity;
        mbundle = bundle;

        PopMenu mPopMenu = new PopMenu.Builder().attachToActivity(activity)
                .addMenuItem(new PopMenuItem("QQ", activity.getResources().getDrawable(R.mipmap.umeng_socialize_qq_on)))
                .addMenuItem(new PopMenuItem("新浪", activity.getResources().getDrawable(R.mipmap.share_weibo)))
                .addMenuItem(new PopMenuItem("人人", activity.getResources().getDrawable(R.mipmap.umeng_socialize_renren_on)))
                .setOnItemClickListener(new PopMenuItemListener() {
                    @Override
                    public void onItemClick(PopMenu popMenu, int position) {
                        String title = mbundle.getString("title");
                        String imageurl = mbundle.getString("imageurl");
                        String url = mbundle.getString("url");
                        String text = mbundle.getString("text");
                        UMImage image = new UMImage(mContext, imageurl);
                        //开启分享
                        UMShareAPI umShareAPI = UMShareAPI.get(mContext);
                        //开启编辑页
                        Config.OpenEditor = true;
                        //分享按钮监听
                        switch (position) {
                            case 0:
                                //QQ
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener)
                                        .withTitle(title)
                                        .withText(text)
                                        .withMedia(image)
                                        .withTargetUrl(url)
                                        .share();
                                break;
                            case 1:
                                //新浪
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.SINA).setCallback(umShareListener)
                                        .withText(title)
                                        .withTitle(text)
                                        .withMedia(image)
                                        .withTargetUrl(url)
                                        .share();

                                break;
                            case 2:
                                //人人
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.RENREN).setCallback(umShareListener)
                                        .withTitle(title)
                                        .withText(text)
                                        .withMedia(image)
                                        .withTargetUrl(url)
                                        .share();

                                break;
                        }

                    }
                })
                .build();
        if (!mPopMenu.isShowing()) {
            mPopMenu.show();
        }
    }

    private static UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            com.umeng.socialize.utils.Log.d("plat", "platform" + platform);
            if (platform.name().equals("WEIXIN_FAVORITE")) {
                Toast.makeText(mContext, platform + " 收藏成功啦", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(mContext, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(mContext, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(mContext, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };


}
