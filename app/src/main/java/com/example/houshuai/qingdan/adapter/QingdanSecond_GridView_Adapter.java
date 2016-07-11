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
import com.example.houshuai.qingdan.bean.ZhuanchangBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.houshuai.qingdan.R.id.layoutContainer;
import static com.example.houshuai.qingdan.R.id.text;

/**专场界面GridView适配器
 * Created by Dufei on 2016/7/9.
 */

public class QingdanSecond_GridView_Adapter extends BaseAdapter {
    private List<ZhuanchangBean.MartshowItemsBean> list;
    private Context context;
    private ViewHolder vh;
//测试
    public QingdanSecond_GridView_Adapter(List<ZhuanchangBean.MartshowItemsBean> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView==null)
        {
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView=inflater.inflate(R.layout.qingdan_second_gridview_item,null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }

        vh.tvPrice.setText("￥"+list.get(i).getPrice()/100);
        vh.tvDiscount.setText(list.get(i).getSale_tip());
        vh.tvGoodName.setText(list.get(i).getTitle());
        if(!"".equals(list.get(i).getImg()))
        {
            Picasso.with(context).load(list.get(i).getImg()).placeholder(R.drawable.loading_placeholder).into(vh.iv);
        }

        return convertView;
    }

    public void reloadData(List<ZhuanchangBean.MartshowItemsBean> data , boolean isClear) {
        if (list != null) {
            if (isClear) {
                list.clear();
            }
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    private final class ViewHolder{
        private TextView tvGoodName,tvDiscount,tvPrice;
        private ImageView iv;
        public ViewHolder(View convertView)
        {
            tvDiscount= (TextView) convertView.findViewById(R.id.tv_discount_id);
            tvGoodName= (TextView) convertView.findViewById(R.id.tv_goodname_id);
            tvPrice= (TextView) convertView.findViewById(R.id.tv_price_id);
            iv= (ImageView) convertView.findViewById(R.id.imgView_id);
        }

    }
}
