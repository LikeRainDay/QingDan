package com.example.houshuai.qingdan.UI.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by HouShuai on 2016/7/5.
 */

public class Self_hasLogin extends BaseFragment {
    @BindView(R.id.self_halogin_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.self_halogin_viewpager)
    ViewPager mViewPager;

    private String[] self_myTitle;


    @Override
    protected int getFragmentID() {
        return R.layout.self_haslogin;
    }


    @Override
    protected void initFragment() {
        initTabLayout();
        initViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
    }


    private void initViewPager() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Self_WenZhangFragment());
        fragments.add(new Self_ShangPinFragment());
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return self_myTitle[position];
            }
        });
        mViewPager.refreshDrawableState();

    }

    private void initTabLayout() {
        self_myTitle = getResources().getStringArray(R.array.self_title);
        for (int i = 0; i < self_myTitle.length; i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setText(self_myTitle[i]);
            mTabLayout.addTab(tab);
        }
    }
}
