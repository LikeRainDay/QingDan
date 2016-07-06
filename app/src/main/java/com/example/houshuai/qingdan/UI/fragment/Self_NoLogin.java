package com.example.houshuai.qingdan.UI.fragment;

import android.view.View;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import butterknife.OnClick;

/**
 * Created by HouShuai on 2016/7/5.
 */

public class Self_NoLogin extends BaseFragment {
    //设置点击事件弹出popwindow
    @OnClick(R.id.button)
    public void button(View view) {

    }

    @Override
    protected int getFragmentID() {
        return R.layout.self_noloagin;
    }

    @Override
    protected void initFragment() {

    }
}
