package com.example.houshuai.qingdan.UI.fragment;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.Custom.MoreWindow;
import com.example.houshuai.qingdan.R;

import butterknife.OnClick;

/**
 * Created by HouShuai on 2016/7/5.
 */

public class Self_NoLogin extends BaseFragment  {

    private MoreWindow mMoreWindow;

    //设置点击事件弹出popwindow
    @OnClick(R.id.button)
    public void button(View view) {
//        if (null == mMoreWindow) {
//            mMoreWindow = new MoreWindow(getActivity());
//            mMoreWindow.init();
//        }
//        mMoreWindow.showMoreWindow(view, 100);
        FragmentTransaction transaction = this.getFragmentManager().beginTransaction();
        transaction.replace(R.id.self_fragment, new Self_loginFragment());
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    protected int getFragmentID() {
        return R.layout.self_noloagin;
    }

    @Override
    protected void initFragment() {

    }


}
