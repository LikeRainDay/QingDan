package com.example.houshuai.qingdan.UI.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.bean.typebean;

import org.xutils.x;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

public class select_product_Activity extends Activity{
    private AutoScrollViewPager auto_view_pager;
    private Intent intent;
    private WebView wv_id;
    private FloatingActionButton btn;
    boolean  bss=false;
    private List<String> imageUrls;
    private List<ImageView> images;
    private TextView brandname_id;
    private TextView fullname_id;
    private Button btn_likecount_id;
    private ListView lv_buylikes_id;
    private typebean.DataBean.ThingsBean thingsBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_product_layout);
        DisplayMetrics dm = getResources().getDisplayMetrics();

        initView();
        final int screenWidth = dm.widthPixels;
        final int screenHeight = dm.heightPixels - 50;

        //获取传过来的对象
        intent = getIntent();

        thingsBean = (typebean.DataBean.ThingsBean) intent.getSerializableExtra("thingsbean");
        //得到图片地址的集合
        imageUrls = thingsBean.getImageUrls();
        //关于图片轮播控件的操作
            aboutviewpager();
        brandname_id.setText(thingsBean.getBrand().getName());
        fullname_id.setText(thingsBean.getName());
        btn_likecount_id.setText("喜欢("+ thingsBean.getLikeCount()+")");
        //对webView进行操作
        WebSettings settings = wv_id.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();// 将浏览器嵌入到WebView控件中
        wv_id.setWebViewClient(client);

        wv_id.loadUrl(thingsBean.getLinks().getHtml());//加载
        //发现浮动按钮
      
    }

    private void initView() {
        wv_id = (WebView)findViewById(R.id.wv_id);
        //发现轮播控件
        auto_view_pager = (AutoScrollViewPager)findViewById(R.id.view_pager);
        //发现指示器框架
        btn_likecount_id = (Button) findViewById(R.id.btn_likecount_id);
        TextView tv_mai_id= (TextView) findViewById(R.id.tv_mai_id);

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
        ImageView iv_backs_id= (ImageView) findViewById(R.id.iv_backs_id);
        iv_backs_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    //关于图片轮播控件的操作
    private void aboutviewpager() {
        //准备数据源
        images = new LinkedList<>();
        if(imageUrls.size()==1){
            for(int i=0;i<10;i++){
                ImageView imageView=new ImageView(select_product_Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                x.image().bind(imageView,imageUrls.get(0));
                images.add(imageView);
            }
        }
        else if(imageUrls.size()==2){
            for(String s:imageUrls){
                for(int i=0;i<imageUrls.size();i++){
                    ImageView imageView=new ImageView(select_product_Activity.this);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    x.image().bind(imageView,imageUrls.get(i));
                    images.add(imageView);
                }
            }
        }else{
            for(int i=0;i<imageUrls.size();i++){
                ImageView imageView=new ImageView(select_product_Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                x.image().bind(imageView,imageUrls.get(i));
                images.add(imageView);
            }
        }

        Toast.makeText(this, images.size()+"",Toast.LENGTH_LONG).show();
        //准备适配器
        MyAdapter adapter=new MyAdapter(images);
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
       LinearLayout pp_ll_id= (LinearLayout) contentView.findViewById(R.id.pp_ll_id);
        lv_buylikes_id = (ListView) contentView.findViewById(R.id.lv_buylikes_id);
        //给这个ListView准备数据源
        final List<typebean.DataBean.ThingsBean.BuylinksBean> buylinks = thingsBean.getBuylinks();
        final List<Map<String,String>> list=new LinkedList<>();
        for(typebean.DataBean.ThingsBean.BuylinksBean buylinksB:buylinks){
            Map<String,String> map=new HashMap<>();
            map.put("address",buylinksB.getPlatform());
            map.put("price",buylinksB.getPrice());
            list.add(map);
        }
        //准备适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(select_product_Activity.this,list,
                R.layout.lv_buylinks_item,new String[]{"address","price"},new int[]{R.id.tv_buyaddress_id,R.id.tv_buyprice_id});
        //绑定适配器
        lv_buylikes_id.setAdapter(simpleAdapter);
        //设置监听器，点击跳转到购买的网站
        lv_buylikes_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(typebean.DataBean.ThingsBean.BuylinksBean buyl:buylinks){
                    if(buyl.getPlatform().equals(list.get(i).get("address"))){
                        Intent intent=new Intent(select_product_Activity.this,select_buy_Activity.class);
                        intent.putExtra("buylink",buyl.getLink());
                        startActivity(intent);
                        return;
                    }
                }
            }
        });

        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int popupHeight= contentView.getMeasuredHeight();
        int popupWidth = contentView.getMeasuredWidth();

        //new一个popwindow
        PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
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

        popupWindow.showAtLocation(pp_ll_id, Gravity.BOTTOM, 0 ,popupHeight+66);

        //popupWindow.showAsDropDown(view);

 }

    //webview的返回上一个html
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_id.canGoBack()) {
            wv_id.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    //浮动按钮的点击事件
    public void fabcheaked(View view ){
        //点击桌面上的可以移动的按钮,弹出一个popwindow,然后执行分享等相关的操作
        showPopupWindow(view);
        Toast.makeText(getApplicationContext(),view.getRight()+"",Toast.LENGTH_LONG).show();
    }
    //自定义适配器
    class MyAdapter extends PagerAdapter {
        //数据源
        private List<ImageView> images;
        public MyAdapter(List<ImageView> images) {
            this.images=images;
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

            container.removeView((View)object);
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
    public void shareClick(View view){

    }
    //评论
    public void reviewClick(View view){

    }
}

