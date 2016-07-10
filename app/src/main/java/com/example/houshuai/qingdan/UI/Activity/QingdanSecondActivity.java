package com.example.houshuai.qingdan.UI.Activity;


import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.adapter.QingdanSecond_GridView_Adapter;
import com.example.houshuai.qingdan.bean.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 清单中第二个页面
 * Created by Dufei on 2016/7/9.
 */

public class QingdanSecondActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    List<Text> data;
    GridView gridView;

    @Override
    protected void initLayout() {

        collapsingToolbar.setTitle("dufei");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        aboutgridView();
    }

    @Override
    protected int getActivityID() {
        return R.layout.activity_qingdan_second;
    }

    private void aboutgridView() {
        gridView = (GridView) findViewById(R.id.gridview_id);
        data = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            data.add(new Text(R.drawable.loading_placeholder, "新品到货，新品到货，新品到货，" + i, "$35", "7.6"));
        }
        QingdanSecond_GridView_Adapter adapter = new QingdanSecond_GridView_Adapter(data, QingdanSecondActivity.this);
        gridView.setAdapter(adapter);
    }
}
