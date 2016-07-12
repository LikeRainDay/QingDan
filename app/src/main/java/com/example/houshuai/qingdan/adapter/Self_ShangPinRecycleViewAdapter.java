package com.example.houshuai.qingdan.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.dao.ShangPin;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HouShuai on 2016/7/11.
 */

public class Self_ShangPinRecycleViewAdapter extends RecyclerView.Adapter<Self_ShangPinRecycleViewAdapter.ViewHolder> {
    private OnItemClickListener mListener;
    private Context mContext;
    private List<ShangPin> mList;

    public Self_ShangPinRecycleViewAdapter(Context mContext, List<ShangPin> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    public interface OnItemClickListener {

        void ItemClickListener(View view, int postion);

        void ItemLongClickListener(View view, int postion);

    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    private List<Integer> heights;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.self_recycleview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
//        layoutParams.height = 550;
        holder.itemView.setLayoutParams(layoutParams);
        //绑定数据
        holder.content.setText(mList.get(position).getImage());
        Picasso.with(mContext).load(mList.get(position).getImage())
                .placeholder(R.mipmap.lanch_icon)
                .error(R.drawable.loading_placeholder)
                .resize(150, 150)
                .centerCrop()
                .into(holder.ImageView);
        holder.title.setText(mList.get(position).getTitle());
        holder.love.setText(mList.get(position).getAddLove());
        holder.see.setText(mList.get(position).getAddSee());
        //监听事件
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemClickListener(holder.itemView, pos);//把事件交给我们实现的接口那里处理
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int pos = holder.getLayoutPosition();//得到当前点击item的位置pos
                    mListener.ItemLongClickListener(holder.itemView, pos);//把事件交给我们实现的接口那里处理
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView26)
        ImageView ImageView;
        @BindView(R.id.textView8)
        TextView title;
        @BindView(R.id.textView9)
        TextView content;
        @BindView(R.id.love)
        TextView love;
        @BindView(R.id.see)
        TextView see;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
