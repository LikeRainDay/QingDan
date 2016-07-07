package com.example.houshuai.qingdan.UI.Custom;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.utils.FastBlur;
import com.example.houshuai.qingdan.utils.KickBackAnimator;
import com.umeng.socialize.Config;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

/*
* 分享的点击监听事件代码
*  if (null == mMoreWindow) {
            mMoreWindow = new MoreWindow(getActivity());
            mMoreWindow.init();
        }
        mMoreWindow.showMoreWindow(view, 100);
* */
public class MoreWindow extends PopupWindow implements OnClickListener {
    private String TAG = MoreWindow.class.getSimpleName();
    Activity mContext;
    private int mWidth;
    private int mHeight;
    private int statusBarHeight;
    private Bitmap mBitmap = null;
    private Bitmap overlay = null;

    private Handler mHandler = new Handler();
    private UMShareAPI umShareAPI;

    public MoreWindow(Activity context) {
        mContext = context;
    }

    public void init() {
        Rect frame = new Rect();
        mContext.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        statusBarHeight = frame.top;
        DisplayMetrics metrics = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay()
                .getMetrics(metrics);
        mWidth = metrics.widthPixels;
        mHeight = metrics.heightPixels;

        setWidth(mWidth);
        setHeight(mHeight);
    }

    private Bitmap blur() {
        if (null != overlay) {
            return overlay;
        }
        long startMs = System.currentTimeMillis();

        View view = mContext.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache(true);
        mBitmap = view.getDrawingCache();

        float scaleFactor = 8;//ͼƬ���ű�����
        float radius = 10;//ģ���̶�
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        overlay = Bitmap.createBitmap((int) (width / scaleFactor), (int) (height / scaleFactor), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(overlay);
        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(mBitmap, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, (int) radius, true);
        Log.i(TAG, "blur time is:" + (System.currentTimeMillis() - startMs));
        return overlay;
    }

    private Animation showAnimation1(final View view, int fromY, int toY) {
        AnimationSet set = new AnimationSet(true);
        TranslateAnimation go = new TranslateAnimation(0, 0, fromY, toY);
        go.setDuration(300);
        TranslateAnimation go1 = new TranslateAnimation(0, 0, -10, 2);
        go1.setDuration(100);
        go1.setStartOffset(250);
        set.addAnimation(go1);
        set.addAnimation(go);

        set.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }

        });
        return set;
    }


    public void showMoreWindow(View anchor, int bottomMargin) {
        final RelativeLayout layout = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.center_music_more_window, null);
        setContentView(layout);

        ImageView close = (ImageView) layout.findViewById(R.id.center_music_window_close);
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.bottomMargin = bottomMargin;
        params.addRule(RelativeLayout.BELOW, R.id.share_weixin);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 200;
        params.leftMargin = 18;
        close.setLayoutParams(params);
        close.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isShowing()) {
                    closeAnimation(layout);
                }
            }

        });

        showAnimation(layout);
        setBackgroundDrawable(new BitmapDrawable(mContext.getResources(), blur()));
        setOutsideTouchable(true);
        setFocusable(true);
        showAtLocation(anchor, Gravity.BOTTOM, 0, statusBarHeight);
    }

    private void showAnimation(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            final View child = layout.getChildAt(i);
            if (child.getId() == R.id.center_music_window_close) {
                continue;
            }
            child.setOnClickListener(this);
            child.setVisibility(View.INVISIBLE);
            mHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    child.setVisibility(View.VISIBLE);
                    ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child, "translationY", 600, 0);
                    fadeAnim.setDuration(300);
                    KickBackAnimator kickAnimator = new KickBackAnimator();
                    kickAnimator.setDuration(150);
                    fadeAnim.setEvaluator(kickAnimator);
                    fadeAnim.start();
                }
            }, i * 50);
        }

    }

    private void closeAnimation(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            final View child = layout.getChildAt(i);
            if (child.getId() == R.id.center_music_window_close) {
                continue;
            }
            child.setOnClickListener(this);
            mHandler.postDelayed(new Runnable() {

                @Override
                public void run() {
                    child.setVisibility(View.VISIBLE);
                    ValueAnimator fadeAnim = ObjectAnimator.ofFloat(child, "translationY", 0, 600);
                    fadeAnim.setDuration(200);
                    KickBackAnimator kickAnimator = new KickBackAnimator();
                    kickAnimator.setDuration(100);
                    fadeAnim.setEvaluator(kickAnimator);
                    fadeAnim.start();
                    fadeAnim.addListener(new AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            child.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {
                            // TODO Auto-generated method stub

                        }
                    });
                }
            }, (layout.getChildCount() - i - 1) * 30);

            if (child.getId() == R.id.shar_xinlang) {
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        dismiss();
                    }
                }, (layout.getChildCount() - i) * 30 + 80);
            }
        }

    }

    @Override
    public void onClick(View v) {

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
        umShareAPI = UMShareAPI.get(mContext);
        //开启编辑页
        Config.OpenEditor = true;
        //分享按钮监听
        // TODO: 2016/7/6 分享操作
        switch (v.getId()) {
            case R.id.shar_xinlang:
                new ShareAction(mContext).setPlatform(SHARE_MEDIA.SINA).setCallback(umShareListener)
                        .withText("Umeng Share")
                        .withTitle("this is title")
                        .withMedia(image)
                        //.withExtra(new UMImage(ShareActivity.this,R.drawable.ic_launcher))
                        .withTargetUrl(url)
                        .share();

                break;
            case R.id.share_QQ:
                new ShareAction(mContext).setPlatform(SHARE_MEDIA.QQ).setCallback(umShareListener)
                        .withTitle("this is title")
                        .withText("hello umeng")
                        .withMedia(image)
                        //.withMedia(music)
                        //.withTargetUrl(url)
                        //.withTitle("qqshare")
                        .share();
                break;
            case R.id.share_weixin:
                new ShareAction(mContext).setPlatform(SHARE_MEDIA.RENREN).setCallback(umShareListener)
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

    public void destroy() {
        if (null != overlay) {
            overlay.recycle();
            overlay = null;
            System.gc();
        }
        if (null != mBitmap) {
            mBitmap.recycle();
            mBitmap = null;
            System.gc();
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
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
