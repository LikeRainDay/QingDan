package com.example.houshuai.qingdan.UI.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import butterknife.BindView;

/**
 * Created by HouShuai on 2016/7/5.
 */

public class Self_hasLogin extends BaseFragment {
    @BindView(R.id.self_halogin_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.self_halogin_viewpager)
    ViewPager mViewPager;

    @Override
    protected int getFragmentID() {
        return R.layout.self_haslogin;
    }

    @Override
    protected void initFragment() {
        initTabLayout();
        initViewPager();
    }

    private void initViewPager() {
// TODO: 2016/7/8  
    }

    private void initTabLayout() {
        String[] self_myTitle = getResources().getStringArray(R.array.self_title);
        for (int i = 0; i < self_myTitle.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(self_myTitle[i]);
            mTabLayout.addTab(tab);
        }
    }
}
