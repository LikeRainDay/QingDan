package com.example.houshuai.qingdan.UI.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.fragment.QingDanFramgment;
import com.example.houshuai.qingdan.UI.fragment.SelfFramgment;
import com.example.houshuai.qingdan.UI.fragment.TiaoXuanFramgment;

import butterknife.BindView;

/*主界面*/
public class MainActivity extends BaseActivity {
    private int[] picSelect = {R.drawable.qingdan_selector, R.drawable.tiaoxuan_selector, R.drawable.self_selector};
    @BindView(R.id.fth_bottom_Tile)
    FragmentTabHost mFragmentTabHost;

    @Override
    protected void initLayout() {
        //初始化FramgnetTabHost
        initFragmentTabHost();
    }

    private void initFragmentTabHost() {
        mFragmentTabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        String[] titleName = getResources().getStringArray(R.array.bottom_title);
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
