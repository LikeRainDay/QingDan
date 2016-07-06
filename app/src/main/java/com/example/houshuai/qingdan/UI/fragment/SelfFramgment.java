package com.example.houshuai.qingdan.UI.fragment;

import android.util.Log;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

/**
 * 个人
 * Created by HouShuai on 2016/7/5.
 */

public class SelfFramgment extends BaseFragment {
    private boolean isLogin;

    @Override
    protected int getFragmentID() {
        return R.layout.self_framgment;
    }

    @Override
    protected void initFragment() {
        initToolbar();
        //初始化底部碎片
        initBottomFragment();
    }

    private void initToolbar() {
        Log.d("des", "----kaishi");
    }

    private void initBottomFragment() {
        if (isLogin == true) {
            getFragmentManager().beginTransaction().replace(R.id.self_fragment, new Self_hasLogin()).commit();
        } else {
            getFragmentManager().beginTransaction().replace(R.id.self_fragment, new Self_hasLogin()).commit();
        }
    }
}
