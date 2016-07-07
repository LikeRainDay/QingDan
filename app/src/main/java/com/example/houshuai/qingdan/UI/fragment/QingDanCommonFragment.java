package com.example.houshuai.qingdan.UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.TextureView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by xiajie on 2016/7/6.
 */

public class QingDanCommonFragment extends ListFragment {


    private  String mTabName;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mTabName=getArguments().getString("tabName");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        List<String> ds = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            ds.add(mTabName + i);

        }

        // 准备适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, ds);

        // 设置适配器
        setListAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(getActivity(), "您选中的是：" + l.getItemAtPosition(position),
                Toast.LENGTH_SHORT).show();
    }
}
