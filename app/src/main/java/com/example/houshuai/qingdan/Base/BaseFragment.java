package com.example.houshuai.qingdan.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类
 * Created by HouShuai on 2016/7/5.
 */

public abstract class BaseFragment extends Fragment {
    private Context mContext;
    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentID(), container, false);
        bind = ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getFragmentID();


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFragment();
    }

    protected abstract void initFragment();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
