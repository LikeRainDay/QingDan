package com.example.houshuai.qingdan.UI.fragment;

import android.support.v4.view.ViewPager;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import butterknife.BindView;

/**
 * 操作模块的viewpager
 * Created by HouShuai on 2016/7/6.
 */

public class QingDan_viewPager extends BaseFragment {
    @BindView(R.id.qingdan_viwpager)
    ViewPager mAutoScrollViewPager;
    //伪数据

    @Override
    protected int getFragmentID() {
        return R.layout.qingdan_viewpager;
    }

    @Override
    protected void initFragment() {
    }

}
