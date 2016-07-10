package com.example.houshuai.qingdan.adapter;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.bean.Text;

import java.util.List;

/**
 * Created by Dufei on 2016/7/9.
 */

public class QingdanSecond_GridView_Adapter extends BaseAdapter {
    private List<Text> data;
    private Context context;
//测试
    public QingdanSecond_GridView_Adapter(List<Text> data,Context context) {
        this.data = data;
        this.context=context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View v=inflater.inflate(R.layout.qingdan_second_gridview_item,null);
        ImageView icon= (ImageView) v.findViewById(R.id.imgView_id);
        TextView goodname= (TextView) v.findViewById(R.id.tv_goodname_id);
        TextView price= (TextView) v.findViewById(R.id.tv_price_id);
        TextView discount= (TextView) v.findViewById(R.id.tv_discount_id);
        Text text=data.get(i);

        icon.setImageResource(text.getIcon());
        goodname.setText(text.getGoodname());
        price.setText(text.getPrice());
        discount.setText(text.getDiscount());

        return v;

    }
}
