package com.example.houshuai.qingdan.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.PopMenu;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItem;
import com.example.houshuai.qingdan.UI.Custom.PopMenuItemListener;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

/**
 * 分享工具类
 * <p>
 * Created by HouShuai on 2016/7/10.
 */

public class ShareUtil {

    private static Context mContext;

    public static void startAuto(final Activity activity) {
        //社会化登录
        mContext = activity;


        PopMenu mPopMenu = new PopMenu.Builder().attachToActivity(activity)
                .addMenuItem(new PopMenuItem("QQ", activity.getResources().getDrawable(R.mipmap.share_wechat)))
                .addMenuItem(new PopMenuItem("新浪", activity.getResources().getDrawable(R.mipmap.share_weibo)))
                .addMenuItem(new PopMenuItem("人人", activity.getResources().getDrawable(R.mipmap.share_wechat_moment)))
                .setOnItemClickListener(new PopMenuItemListener() {
                    @Override
                    public void onItemClick(PopMenu popMenu, int position) {
                        //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.info_icon_1);
                        //UMImage image = new UMImage(ShareActivity.this,bitmap);
                        //UMImage image = new UMImage(ShareActivity.this,new File("/SDCARD/image_jpg.jpg"));
                        UMusic music = new UMusic("http://music.huoxing.com/upload/20130330/1364651263157_1085.mp3");
                        //UMusic music = new UMusic("http://y.qq.com/#type=song&mid=002I7CmS01UAIH&tpl=yqq_song_detail");
                        music.setTitle("This is music title");
                        music.setThumb("http://www.umeng.com/images/pic/social/chart_1.png");
                        music.setDescription("my description");
                        // share video
                        UMVideo video = new UMVideo("http://video.sina.com.cn/p/sports/cba/v/2013-10-22/144463050817.html");
                        video.setThumb("http://www.adiumxtras.com/images/thumbs/dango_menu_bar_icon_set_11_19047_6240_thumb.png");
                        // share URL
                        String url = "http://www.umeng.com";
                        UMImage image = new UMImage(mContext, "http://www.umeng.com/images/pic/social/integrated_3.png");


                        //开启分享
                        UMShareAPI umShareAPI = UMShareAPI.get(mContext);
                        //开启编辑页
                        Config.OpenEditor = true;
                        //分享按钮监听
                        switch (position) {
                            case 0:
                                //QQ
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener)
                                        .withTitle("this is title")
                                        .withText("hello umeng")
                                        .withMedia(image)
                                        //.withMedia(music)
                                        //.withTargetUrl(url)
                                        //.withTitle("qqshare")
                                        .share();

                                break;
                            case 1:
                                //新浪
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.SINA).setCallback(umShareListener)
                                        .withText("Umeng Share")
                                        .withTitle("this is title")
                                        .withMedia(image)
                                        //.withExtra(new UMImage(ShareActivity.this,R.drawable.ic_launcher))
                                        .withTargetUrl(url)
                                        .share();

                                break;
                            case 2:
                                //人人
                                new ShareAction((Activity) mContext).setPlatform(SHARE_MEDIA.RENREN).setCallback(umShareListener)
                                        .withTitle("this is title")
                                        .withText("hello umeng")
                                        .withMedia(image)
                                        //.withMedia(music)
                                        //.withTargetUrl(url)
                                        //.withTitle("qqshare")
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
