package com.example.houshuai.qingdan.UI.Activity;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.bean.typebean;
import com.example.houshuai.qingdan.dao.ShangPin;
import com.example.houshuai.qingdan.utils.GetIsLogin;
import com.example.houshuai.qingdan.utils.ShangPinDBHelper;
import com.example.houshuai.qingdan.utils.ShareUtil;
import com.umeng.socialize.utils.Log;

import org.xutils.DbManager;
import org.xutils.common.util.LogUtil;
import org.xutils.x;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class select_product_Activity extends Activity {
    private AutoScrollViewPager auto_view_pager;
    private Intent intent;
    private WebView wv_id;
    private List<String> imageUrls;
    private List<ImageView> images;
    private TextView brandname_id;
    private TextView fullname_id;
    private Button btn_likecount_id;
    private ListView lv_buylikes_id;
    private typebean.DataBean.ThingsBean thingsBean;
    private TextView tv_xiepinglun_id;
    private TextView tv_mai_id;
    private PopupWindow popWindowsss;
    private LinearLayout dibu_id;
    private ListView lv_pinglun_id;
    private EditText et_id;
    private boolean a = true;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_product_layout);
        DisplayMetrics dm = getResources().getDisplayMetrics();


        initView();
        //获取传过来的对象
        intent = getIntent();

        thingsBean = (typebean.DataBean.ThingsBean) intent.getSerializableExtra("thingsbean");

        //得到图片地址的集合
        imageUrls = thingsBean.getImageUrls();
        //关于图片轮播控件的操作
        aboutviewpager();
        brandname_id.setText(thingsBean.getBrand().getName());
        fullname_id.setText(thingsBean.getName());
        //给这个喜欢设置了喜欢的个数
        btn_likecount_id.setText("喜欢(" + thingsBean.getLikeCount() + ")");

        aboutWebview();
        //关于数据库,数据库不写了
        // aboutDb();
    }

    private void aboutDb() {
        //创建数据库,等到做完了，然后将数据的建立移到ａｐｐ类中
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                // 数据库的名字
                .setDbName("shangping")
                // 保存到指定路径
                .setDbDir(new
                        File(Environment.getExternalStorageDirectory().getAbsolutePath()))
                // 数据库的版本号
                .setDbVersion(1)
                // 数据库版本更新监听
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager arg0, int arg1, int arg2) {
                        LogUtil.e("数据库版本更新了！");
                    }
                });
        DbManager manager = x.getDb(daoConfig);

        //创建对象，用来生成表
    }

    private void aboutWebview() {
        //对webView进行操作
        WebSettings settings = wv_id.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();// 将浏览器嵌入到WebView控件中
        wv_id.setWebViewClient(client);
        wv_id.loadUrl(thingsBean.getLinks().getHtml());//加载
    }


    private void initView() {
        wv_id = (WebView) findViewById(R.id.wv_id);
        //发现轮播控件
        auto_view_pager = (AutoScrollViewPager) findViewById(R.id.view_pager);
        //发现指示器框架
        btn_likecount_id = (Button) findViewById(R.id.btn_likecount_id);
        tv_mai_id = (TextView) findViewById(R.id.tv_mai_id);
        dibu_id = (LinearLayout) findViewById(R.id.dibu_id);
        tv_xiepinglun_id = (TextView) findViewById(R.id.tv_xiepinglun_id);

        brandname_id = (TextView) findViewById(R.id.brandname_id);
        fullname_id = (TextView) findViewById(R.id.fullname_id);


        //点击购买按钮，弹出对应的popuwindow
        tv_mai_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在这个控件上面弹出一个popuwindow
                showPopupWindow(view);

            }
        });
        ImageView iv_backs_id = (ImageView) findViewById(R.id.iv_backs_id);
        iv_backs_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        //当评论按钮被点击的时候，从底部弹出一个popuwindow
        tv_xiepinglun_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                showPopup(tv_xiepinglun_id);

            }

        });
        //显示评论的listView
        lv_pinglun_id = (ListView) findViewById(R.id.lv_pinglun_id);

    }

    //弹出popuwindow
    private void showPopup(TextView tv_xiepinglun_id) {
        //弹出popuwindow
        dibu_id.setVisibility(View.GONE);

        LayoutInflater layoutInflater = (LayoutInflater) select_product_Activity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.pinglun_item, null);
        et_id = (EditText) view.findViewById(R.id.et_id);
        et_id.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        et_id.setFocusable(true);
        et_id.setFocusableInTouchMode(true);
        et_id.setSingleLine(false);
        //水平滚动设置为False
        et_id.setHorizontallyScrolling(false);
        // 创建一个PopuWidow对象
        popWindowsss = new PopupWindow(view, LinearLayout.LayoutParams.FILL_PARENT,
                250, true);

        //弹出时的动画
        popWindowsss.setAnimationStyle(R.style.popWindow_anim_style);
        // 使其聚集 ，要想监听菜单里控件的事件就必须要调用此方法
        popWindowsss.setFocusable(true);
        // 设置允许在外点击消失
        popWindowsss.setOutsideTouchable(false);
        // 设置背景，这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popWindowsss.setBackgroundDrawable(new BitmapDrawable());
        //软键盘不会挡着popupwindow
        popWindowsss.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //设置菜单显示的位置
        popWindowsss.showAtLocation(tv_mai_id, Gravity.BOTTOM, 0, 0);
        //监听菜单的关闭事件
        popWindowsss.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                dibu_id.setVisibility(View.VISIBLE);
            }
        });
        //监听触屏事件
        popWindowsss.setTouchInterceptor(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                return false;
            }
        });
        //调出键盘
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) et_id.getContext().getSystemService(Service.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);

            }
        }).start();

    }

    //关于图片轮播控件的操作
    private void aboutviewpager() {
        //准备数据源
        images = new LinkedList<>();
        if (imageUrls.size() == 1) {
            for (int i = 0; i < 10; i++) {
                ImageView imageView = new ImageView(select_product_Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                x.image().bind(imageView, imageUrls.get(0));
                images.add(imageView);
            }
        } else if (imageUrls.size() == 2) {
            for (String s : imageUrls) {
                for (int i = 0; i < imageUrls.size(); i++) {
                    ImageView imageView = new ImageView(select_product_Activity.this);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    x.image().bind(imageView, imageUrls.get(i));
                    images.add(imageView);
                }
            }
        } else {
            for (int i = 0; i < imageUrls.size(); i++) {
                ImageView imageView = new ImageView(select_product_Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                x.image().bind(imageView, imageUrls.get(i));
                images.add(imageView);
            }
        }

        Toast.makeText(this, images.size() + "", Toast.LENGTH_LONG).show();
        //准备适配器
        MyAdapter adapter = new MyAdapter(images);
        //绑定适配器
        auto_view_pager.setAdapter(adapter);

        auto_view_pager.startAutoScroll();

        //解决最后一个跳转到第一个闪动问题
        auto_view_pager.setCurrentItem((Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % images.size()));
        //设置延时时间setInterval(long) 设置自动滚动的间隔时间，单位为毫秒
        auto_view_pager.setInterval(2000);
        //设置轮播的方向 AutoScrollViewPager.RIGHT/AutoScrollViewPager.LEFT默认向右
        //auto_view_pager.setDirection(AutoScrollViewPager.RIGHT);
        //设置是否自动循环轮播，默认为true
        //注意：一旦设为true，则不能和ViewPagerIndicator一起使用
        auto_view_pager.setCycle(true);
        //设置切换动画的时长
        auto_view_pager.setScrollDurationFactor(3);
        //设置当滑动到最后一个或者第一个时，如何切换下一张
        /**
         * SLIDE_BORDER_MODE_NONE：不能再滑动
         * SLIDE_BORDER_MODE_TO_PARENT：移动父视图的Pager
         * SLIDE_BORDER_MODE_CYCLE：循环
         * 默认为SLIDE_BORDER_MODE_NONE
         */
        auto_view_pager.setSlideBorderMode(AutoScrollViewPager.SLIDE_BORDER_MODE_TO_PARENT);
        //当滑动到最后一张或第一张时是否开启动画，默认为true
        auto_view_pager.setBorderAnimation(true);
        //当触摸的时候，停止轮播

        //设置监听器，当图片变化的时候，对应的小圆点的状态发生状态
        auto_view_pager.setStopScrollWhenTouch(true);
        //关于小圆点的操作
        //TODO


    }

    //popuwindow
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.popuwindow_buy_item, null);
        LinearLayout pp_ll_id = (LinearLayout) contentView.findViewById(R.id.pp_ll_id);
        lv_buylikes_id = (ListView) contentView.findViewById(R.id.lv_buylikes_id);
        //给这个ListView准备数据源
        final List<typebean.DataBean.ThingsBean.BuylinksBean> buylinks = thingsBean.getBuylinks();
        final List<Map<String, String>> list = new LinkedList<>();
        for (typebean.DataBean.ThingsBean.BuylinksBean buylinksB : buylinks) {
            Map<String, String> map = new HashMap<>();
            map.put("address", buylinksB.getPlatform());
            map.put("price", buylinksB.getPrice());
            list.add(map);
        }
        //准备适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(select_product_Activity.this, list,
                R.layout.lv_buylinks_item, new String[]{"address", "price"}, new int[]{R.id.tv_buyaddress_id, R.id.tv_buyprice_id});
        //绑定适配器
        lv_buylikes_id.setAdapter(simpleAdapter);
        //设置监听器，点击跳转到购买的网站
        lv_buylikes_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (typebean.DataBean.ThingsBean.BuylinksBean buyl : buylinks) {
                    if (buyl.getPlatform().equals(list.get(i).get("address"))) {
                        Intent intent = new Intent(select_product_Activity.this, select_buy_Activity.class);
                        intent.putExtra("buylink", buyl.getLink());
                        startActivity(intent);
                        return;
                    }
                }
            }
        });

        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int popupHeight = contentView.getMeasuredHeight();
        int popupWidth = contentView.getMeasuredWidth();

        //new一个popwindow
        PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);//popopwindow可以被点击
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        ColorDrawable cd = new ColorDrawable(getResources().getColor(R.color.aliceblue));
        popupWindow.setBackgroundDrawable(cd);
        // 设置好参数之后再show
        int[] location = new int[2];
        pp_ll_id.getLocationOnScreen(location);

        popupWindow.showAtLocation(pp_ll_id, Gravity.BOTTOM, 0, popupHeight + 66);

        //popupWindow.showAsDropDown(view);

    }

    //webview的返回上一个html
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_id.canGoBack()) {
            wv_id.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //浮动按钮的点击事件
    public void fabcheaked(View view) {
        //点击桌面上的可以移动的按钮,弹出一个popwindow,然后执行分享等相关的操作
        showPopupWindow(view);
        Toast.makeText(getApplicationContext(), view.getRight() + "", Toast.LENGTH_LONG).show();
    }

    //自定义适配器
    class MyAdapter extends PagerAdapter {
        //数据源
        private List<ImageView> images;

        public MyAdapter(List<ImageView> images) {
            this.images = images;
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //将数据源中取出的数据挂载到ViewPager上面

            container.removeView(images.get(position % images.size()));
            container.addView(images.get(position % images.size()));
            return images.get(position % images.size());

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开启自动轮播，延时时间为getInterval()
        //auto_view_pager.startAutoScroll();
        //开启自动轮播，并设置延时
        auto_view_pager.startAutoScroll(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //停止轮播
        auto_view_pager.stopAutoScroll();
    }

    //分享
    public void shareClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("title", thingsBean.getName());
        bundle.putString("imageurl", thingsBean.getImageUrls().get(0));
        bundle.putString("url", thingsBean.getLinks().getShare());
        bundle.putString("text", thingsBean.getFullName());
        ShareUtil.startAuto(this, bundle);
    }

    //评论
    public void reviewClick(View view) {
        showPopup(tv_xiepinglun_id);
    }

    //发表
    public void fabiao(View view) {
        //思路：
        //判断用户是否登录，如果已经登录，获取该用户的头像和昵称
        if (new GetIsLogin(select_product_Activity.this).IsLogin()) {
            App application = (App) getApplication();

            List<String> mySharePerference = (application).getMySharePerference(application.mID);
            //获到用户名
            String name = mySharePerference.get(4);
            //获得密码
            String touxiang = mySharePerference.get(2);
            //获取用户在editView上面输入的内容,然后判断内容是否为空，如果为空，则提示用户
            String s = et_id.getText().toString().trim();
            if (s != null) {
                //获取当前的时间
                long time = System.currentTimeMillis();
                //将用户的所有的数据存入数据库中

                //然后从数据库中取出数据，显示到listView上面
                //准备适配器
                //设置适配器
                //绑定适配器
                //设置监听器
            } else {
                Toast.makeText(this, "评论不能为空！！！请输入后再评论", Toast.LENGTH_LONG).show();
            }

        } else {
            //如果用户没有登录，则提示用户登录或者直接跳转到登录界面
            Toast.makeText(this, "请先登录，", Toast.LENGTH_LONG).show();

        }


    }

    //喜欢
    public void likeCilck(View view) {
        //根据当前的点击状态修改里面的值
        text = (String) btn_likecount_id.getText();
        int i = Integer.parseInt(text.substring(3, text.length() - 1));
        if (a == true) {
            btn_likecount_id.setText("喜欢(" + (i + 1) + ")");
            btn_likecount_id.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.heart_purple, 0, 0);
            //获取数据库，修改里面的值
            ShangPin shangPin = new ShangPin();
            shangPin.setAddLove(thingsBean.getPrice());//价钱
            shangPin.setAddSee(i + 1 + "");//喜欢的人数
            shangPin.setContent(thingsBean.getBrand().getName());//品牌名字
            shangPin.setImage(thingsBean.getImageUrls().get(0));//图片的地址
            shangPin.setTitle(thingsBean.getName());//产品的名字
            shangPin.setUrl(thingsBean.getLinks().getShare());//产品描述地址
            ShangPinDBHelper.getInstance(this).addToMessageInfoTable(shangPin);
            a = false;
            Log.i("ss", "运行了呃呃呃额额");
        } else if (a == false) {
            Log.i("ss", "运行了");
            btn_likecount_id.setText("喜欢(" + (i - 1) + ")");
            btn_likecount_id.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.heart_o_alt, 0, 0);
            a = true;
        }
    }
}

