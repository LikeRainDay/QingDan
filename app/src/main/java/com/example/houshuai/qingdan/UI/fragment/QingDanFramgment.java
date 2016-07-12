package com.example.houshuai.qingdan.UI.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.adapter.Find_tab_Adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * 清单
 * Created by HouShuai on 2016/7/5.
 */

public class QingDanFramgment  extends BaseFragment {

    @BindView(R.id.qingdan_tl)
    TabLayout tl;

    @BindView(R.id.qindan_viewpager2)
    ViewPager vp;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private String[] tabNames={"上新","女装","鞋包","居家","美妆","美食","母婴"};
    private String[] types={"news","nvzhuang","xiebao","jujia","meizhuang","meishi","muying"};

    @Override
    protected int getFragmentID() {
        return R.layout.qingdan_framgment;
    }

    @Override
    protected void initFragment() {

        mTitles=new ArrayList<>();
        Collections.addAll(mTitles,tabNames);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        mFragments=new LinkedList<>();
        for(int i=0;i<mTitles.size();i++)
        {
            String tabName=mTitles.get(i);
            String type=types[i];
            QingDanCommonFragment framgment=new QingDanCommonFragment();
            Bundle arg=new Bundle();
            arg.putString("type",type);
            framgment.setArguments(arg);
            mFragments.add(framgment);
            tl.addTab(tl.newTab().setText(tabName));
        }

       Find_tab_Adapter fragmentAdapter=new Find_tab_Adapter(getChildFragmentManager(),mFragments,mTitles);
        vp.setAdapter(fragmentAdapter);
        tl.setupWithViewPager(vp);
    }



}
