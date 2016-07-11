package com.example.houshuai.qingdan.alipay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.houshuai.qingdan.R;

/**
 * Created by Dufei on 2016/7/11.
 */

public class AlipayExternalFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pay_external, container, false);
    }
}
