package com.example.houshuai.qingdan.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.bean.CategoryListBean;
import com.example.houshuai.qingdan.bean.NewListBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by xiajie on 2016/7/7.
 */

public class Qingdan_list_Adapter extends BaseAdapter {


    private Activity activity;
    private List<NewListBean.MzMartshowsBean> list;
    private  ViewHolder vh=null;

    public Qingdan_list_Adapter(List<NewListBean.MzMartshowsBean> list, Activity activity) {
        Log.i("TAG","new Adapter");
        this.list = list;
        this.activity = activity;

    }

    public void reloadData(List<NewListBean.MzMartshowsBean> data , boolean isClear) {
        if (list != null) {
            if (isClear) {
                list.clear();
            }
            list.addAll(data);
            notifyDataSetChanged();
        }
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
            convertView=activity.getLayoutInflater().inflate(R.layout.qingdan_list_item,null);
            vh=new ViewHolder(convertView);
            convertView.setTag(vh);
        }else {
           vh= (ViewHolder) convertView.getTag();
        }


            vh.discountTv.setText( list.get(i).getPromotion());
            vh.titleTv.setText( list.get(i).getTitle());
            vh.manjianTv.setText( list.get(i).getMj_promotion());
            if (!"".equals( list.get(i).getLabel_img_tr()))
            {
                Picasso.with(activity).load( list.get(i).getLabel_img_tr()).into(vh.newIv);
            }
            if (!"".equals(list.get(i).getMain_img()))
            {
                Picasso.with(activity).load( list.get(i).getMain_img()).config(Bitmap.Config.RGB_565).placeholder(R.drawable.loading_placeholder).into(vh.mainIv);
            }


        return convertView;
    }



    private final class ViewHolder{
        private ImageView mainIv,manjianIv,newIv;
        private TextView manjianTv,titleTv,discountTv;


        public ViewHolder(View convertView) {
            mainIv= (ImageView) convertView.findViewById(R.id.qingdan_listitem_mainimg);
            manjianIv= (ImageView) convertView.findViewById(R.id.qingdan_listitem_mj_iv);
            newIv= (ImageView) convertView.findViewById(R.id.qingdan_listitem_new);
            manjianTv= (TextView) convertView.findViewById(R.id.qingdan_listitem_mj_promotion);
            discountTv= (TextView) convertView.findViewById(R.id.qingdan_listitem_min_discount);
            titleTv= (TextView) convertView.findViewById(R.id.qingdan_listitem_excerpt);
        }
    }
}
