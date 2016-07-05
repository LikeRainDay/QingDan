package com.example.houshuai.qingdan.UI.fragment;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

/**
 * 清单
 * Created by HouShuai on 2016/7/5.
 */

public class QingDanFramgment  extends BaseFragment{
    private int[] viewPager = {R.drawable.tabbar_btn_personage_hl, R.drawable.tabbar_btn_personage_hl, R.drawable.tabbar_btn_personage_hl};

    @Override
    protected int getFragmentID() {
        return R.layout.qingdan_framgment;
    }

    @Override
    protected void initFragment() {

    }
}
