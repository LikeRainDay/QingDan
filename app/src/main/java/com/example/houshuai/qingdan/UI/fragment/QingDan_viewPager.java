package com.example.houshuai.qingdan.UI.fragment;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import butterknife.BindView;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * 操作模块的viewpager
 * Created by HouShuai on 2016/7/6.
 */

public class QingDan_viewPager extends BaseFragment {
    @BindView(R.id.qingdan_viwpager)
    AutoScrollViewPager mAutoScrollViewPager;
    //伪数据
    private int[] picViewPager = {R.mipmap.bg_6, R.mipmap.bg_7, R.mipmap.bg_8, R.mipmap.bg_9, R.mipmap.bg_10};

    @Override
    protected int getFragmentID() {
        return R.layout.qingdan_viewpager;
    }

    @Override
    protected void initFragment() {

    }
}
