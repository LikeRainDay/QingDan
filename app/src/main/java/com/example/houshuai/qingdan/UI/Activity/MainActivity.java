package com.example.houshuai.qingdan.UI.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.Receive.MyReceiver;
import com.example.houshuai.qingdan.UI.fragment.QingDanFramgment;
import com.example.houshuai.qingdan.UI.fragment.QingDan_viewPager;
import com.example.houshuai.qingdan.UI.fragment.SelfFramgment;
import com.example.houshuai.qingdan.UI.fragment.Self_Head;
import com.example.houshuai.qingdan.UI.fragment.Self_NoLogin;
import com.example.houshuai.qingdan.UI.fragment.TiaoXuanFramgment;
import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;


/*主界面*/
public class MainActivity extends BaseActivity {
    private int[] picSelect = {R.drawable.qingdan_selector, R.drawable.tiaoxuan_selector, R.drawable.self_selector};
    @BindView(R.id.fth_bottom_Tile)
    FragmentTabHost mFragmentTabHost;
    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_name)
    TextView mTextView;
    private String[] titleName;
    public static boolean isForeground = false;


    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new MyReceiver());
    }

    @Override
    protected void initLayout() {
        setSupportActionBar(mToolbar);
        //初始化FramgnetTabHost
        initFragmentTabHost();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_ToolbarFragment, new QingDan_viewPager()).commit();
    }

    private void initFragmentTabHost() {
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        titleName = getResources().getStringArray(R.array.bottom_title);
        for (int i = 0; i < titleName.length; i++) {
            String s = titleName[i];
            TabHost.TabSpec tabSpec = mFragmentTabHost.newTabSpec(s);
            tabSpec.setIndicator(getDataView(i, s));
            Bundle bundle = new Bundle();
            bundle.putString("name", s);
            bundle.putInt("i", i);
            switch (i) {
                case 0:
                    mFragmentTabHost.addTab(tabSpec, QingDanFramgment.class, bundle);
                    break;
                case 1:
                    mFragmentTabHost.addTab(tabSpec, TiaoXuanFramgment.class, bundle);
                    break;
                case 2:
                    mFragmentTabHost.addTab(tabSpec, SelfFramgment.class, bundle);
                    break;
            }
        }

        mFragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                // TODO: 2016/7/5  动态监听
                switch (s) {
                    case "清单":
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_ToolbarFragment, new QingDan_viewPager()).commit();
                    mTextView.setText("清单");
                        break;
                    case "挑选":
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_ToolbarFragment, new Self_NoLogin()).commit();
                    mTextView.setText("登录");
                        break;
                    case "个人":
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_ToolbarFragment, new Self_Head()).commit();
                    mTextView.setText("未登录");
                        break;

                }
            }
        });
    }

    private View getDataView(int i, String s) {
        View view = View.inflate(this, R.layout.bottom_title, null);
        ImageView imgeview = (ImageView) view.findViewById(R.id.image_bottom);
        imgeview.setImageResource(picSelect[i]);
        return view;
    }

    @Override
    protected int getActivityID() {
        return R.layout.activity_main;
    }

}
