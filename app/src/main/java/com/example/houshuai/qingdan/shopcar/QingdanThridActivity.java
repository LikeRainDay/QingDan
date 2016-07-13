package com.example.houshuai.qingdan.shopcar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.alipay.AlipayActivity;
import com.example.houshuai.qingdan.bean.Constant;
import com.example.houshuai.qingdan.bean.GoodsBean;
import com.example.houshuai.qingdan.dao.ShangPin;
import com.example.houshuai.qingdan.inter.QingdanInter;
import com.example.houshuai.qingdan.utils.RetrofitUtils;
import com.example.houshuai.qingdan.utils.ShangPinDBHelper;
import com.example.houshuai.qingdan.utils.ShareUtil;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QingdanThridActivity extends FragmentActivity implements QingdanOrderPopWindow.OnItemClickListener, OnClickListener {

    NfcAdapter nfcAdapter;
    private ImageView mainImg;
    private ListView listView;
    private ImageView iv_baby_collection;
    /**
     * 弹出商品订单信息详情
     */
    private QingdanOrderPopWindow popWindow;
    /**
     * 用于设置背景暗淡
     */
    private LinearLayout all_choice_layout = null;
    /**
     * 判断是否点击的立即购买按钮
     */
    boolean isClickBuy = false;
    /**
     * 是否添加收藏
     */
    private static boolean isCollection = false;
    /**
     * ViewPager当前显示页的下标
     */
    private int position = 0;
    private int iid;
    private QingdanInter serverInter;
    private Call<GoodsBean> call_result;
    private GoodsBean goodsBean;
    private TextView tvGoodName, tvGoodDesc, tvGoodPrice, tvGoodDiscount, tvMianjian, tvTips;

    //购物车页面
    private Cart_F cart_F;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qingdan_thrid);
        iid = getIntent().getIntExtra("iid", 0);
        initView();
    }


    @SuppressLint("NewApi")
    private void initView() {
        // 获取默认的NFC控制器
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            //Toast.makeText(this, "该设备不支持NFC", Toast.LENGTH_SHORT).show();
        }
        ((ImageView) findViewById(R.id.iv_back)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_share)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.put_in)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.buy_now)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.iv_shoping_cat)).setOnClickListener(this);
        findViewById(R.id.xuanze_id).setOnClickListener(this);

        iv_baby_collection = (ImageView) findViewById(R.id.iv_baby_collection);
        iv_baby_collection.setOnClickListener(this);
        all_choice_layout = (LinearLayout) findViewById(R.id.all_choice_layout);
        listView = (ListView) findViewById(R.id.listView_Detail);
        listView.setFocusable(false);
        listView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        listView.setAdapter(new QingdanThridCommentListVIewAdapter(this));
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(QingdanThridActivity.this, "你点击了", Toast.LENGTH_SHORT).show();
                //进入恋上猫女衣坊的网店
                //Uri uri = Uri.parse("http://yecaoly.taobao.com");
                //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //startActivity(intent);
            }
        });

        if (isCollection) {
            //如果已经收藏，则显示收藏后的效果
            iv_baby_collection.setImageResource(R.drawable.second_2_collection);
        }
        mainImg = (ImageView) findViewById(R.id.qingdan_good_mainimg);
        tvGoodName = (TextView) findViewById(R.id.qingdan_good_name);
        tvGoodDesc = (TextView) findViewById(R.id.qingdan_good_desc);
        tvGoodPrice = (TextView) findViewById(R.id.qingdan_good_price);
        tvGoodDiscount = (TextView) findViewById(R.id.qingdan_good_diasount);
        tvMianjian = (TextView) findViewById(R.id.qingdan_good_manjan);
        tvTips = (TextView) findViewById(R.id.qingdang_good_tips);
        getGoodsInfo();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                //返回
                this.finish();
                break;
            case R.id.iv_share:
                if (goodsBean != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", goodsBean.getShare_info().getShare_title());
                    bundle.putString("imgurl", goodsBean.getMain_img());
                    bundle.putString("url", goodsBean.getShare_info().getShare_link());
                    bundle.putString("text", goodsBean.getShare_info().getShare_desc());
                    ShareUtil.startAuto(QingdanThridActivity.this, bundle);
                }

                break;
            case R.id.iv_baby_collection:
                //收藏
                if (goodsBean != null) {
                    if (isCollection) {//提示是否取消收藏
                        cancelCollection();
                        iv_baby_collection.setImageResource(R.drawable.second_2);
                    } else {
                        isCollection = true;

                        setSaveCollection();
                        //如果已经收藏，则显示收藏后的效果
                        iv_baby_collection.setImageResource(R.drawable.second_2_collection);
                        Toast.makeText(this, "收藏成功", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
            case R.id.put_in:
                //添加购物车
                isClickBuy = false;
                setBackgroundBlack(all_choice_layout, 0);
                popWindow.showAsDropDown(view);
                break;
            case R.id.buy_now:
                //立即购买
                isClickBuy = true;
                setBackgroundBlack(all_choice_layout, 0);
                popWindow.showAsDropDown(view);
                break;
            case R.id.iv_shoping_cat:
                Intent intent = new Intent();
                intent.setClass(QingdanThridActivity.this, QingdanShopCar.class);
                Toast.makeText(QingdanThridActivity.this, "daiwanshan........", Toast.LENGTH_LONG).show();
                startActivity(intent);
                break;

            case R.id.xuanze_id:
                //Toast.makeText(QingdanThridActivity.this, "你点击了", Toast.LENGTH_SHORT).show();
                isClickBuy = false;
                setBackgroundBlack(all_choice_layout, 0);
                popWindow.showAsDropDown(view);
        }
    }


    /**
     * 获取商品信息
     *
     * @return
     */
    public void getGoodsInfo() {

        serverInter = RetrofitUtils.initRetrofit(Constant.BASE_URL_GOODBEAN);
        call_result = serverInter.getGoodsInfo(iid);
        call_result.enqueue(new Callback<GoodsBean>() {
            @Override
            public void onResponse(Call<GoodsBean> call, Response<GoodsBean> response) {
                if (response.isSuccess() && response.body() != null) {
                    goodsBean = response.body();
                    Log.i("TAG", "--------GoodsBeans：" + goodsBean.getTitle());
                    tvGoodDiscount.setText((goodsBean.getDiscount() / 10) + "折起");
                    tvGoodName.setText(goodsBean.getTitle());
                    tvGoodDesc.setText(goodsBean.getDesc());
                    tvGoodPrice.setText("￥" + (goodsBean.getPrice() / 100) + "");
                    StringBuffer tips = new StringBuffer();
                    for (int i = 0; i < goodsBean.getItem_tips().size(); i++) {
                        tips.append("  " + goodsBean.getItem_tips().get(i));
                    }
                    tvTips.setText(tips);
                    if (!"".equals(goodsBean.getMain_img())) {
                        Picasso.with(QingdanThridActivity.this).load(goodsBean.getMain_img()).placeholder(R.drawable.loading_placeholder).into(mainImg);
                    }
                    popWindow = new QingdanOrderPopWindow(QingdanThridActivity.this, goodsBean.getTitle(), goodsBean.getMain_img(), (goodsBean.getPrice() / 100) + "");
                    popWindow.setOnItemClickListener(QingdanThridActivity.this);
                }
            }

            @Override
            public void onFailure(Call<GoodsBean> call, Throwable t) {
                Toast.makeText(QingdanThridActivity.this, "网络异常，加载失败！", Toast.LENGTH_LONG).show();
            }
        });

    }

    //点击弹窗的确认按钮的响应
    @Override
    public void onClickOKPop() {
        setBackgroundBlack(all_choice_layout, 1);

        if (isClickBuy) {
            //如果之前是点击的立即购买，那么就跳转到立即购物界面
            //Toast.makeText(MainActivity.this, "跳转到购物页面", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QingdanThridActivity.this, AlipayActivity.class);
            intent.putExtra("goodName", goodsBean.getTitle());
            intent.putExtra("shipCity", goodsBean.getShip_city());
            intent.putExtra("price", goodsBean.getPrice());
            intent.putExtra("imgUrl", goodsBean.getMain_img());
            startActivity(intent);
        } else {

            Toast.makeText(this, "添加到购物车成功", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 控制背景变暗 0变暗 1变亮
     */
    public void setBackgroundBlack(View view, int what) {
        switch (what) {
            case 0:
                view.setVisibility(View.VISIBLE);
                break;
            case 1:
                view.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 保存是否添加收藏
     */
    private void setSaveCollection() {
        ShangPin shangPin = new ShangPin();
        shangPin.setTitle(goodsBean.getTitle());
        shangPin.setImage(goodsBean.getMain_img());
        shangPin.setAddLove((goodsBean.getPrice() / 100) + "");
        shangPin.setAddSee(goodsBean.getFocus_num() + "");
        shangPin.setContent(goodsBean.getDesc());
        shangPin.setUrl(goodsBean.getIid() + "");
        ShangPinDBHelper.getInstance(this).addToMessageInfoTable(shangPin);
    }

    /**
     * 取消收藏
     */
    private void cancelCollection() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("是否取消收藏");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                isCollection = false;
                //如果取消收藏，则显示取消收藏后的效果
                ShangPinDBHelper.getInstance(QingdanThridActivity.this).deleteMessageInfoListBy(goodsBean.getIid() + "");
            }
        });
        dialog.setNegativeButton("取消", null);
        dialog.create().show();

    }

}
