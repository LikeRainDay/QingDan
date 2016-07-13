package com.example.houshuai.qingdan.UI.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.QingdanSecondActivity;
import com.example.houshuai.qingdan.adapter.Self_WenZhangRecycleViewAdapter;
import com.example.houshuai.qingdan.dao.WenZhang;
import com.example.houshuai.qingdan.utils.WenZhangDBHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by HouShuai on 2016/7/11.
 */

public class Self_WenZhangFragment extends BaseFragment {

    @BindView(R.id.self_recycle_view)
    RecyclerView mRecyclerView;
    private List<WenZhang> mList = new ArrayList<>();
    @BindView(R.id.swip_refresh)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private Self_WenZhangRecycleViewAdapter self_recycleViewAdapter;

    public void initRefresh() {
        mSwipeRefreshLayout.setProgressViewOffset(true, -20, 100);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.swiperefresh_color1, R.color.swiperefresh_color2, R.color.swiperefresh_color3, R.color.swiperefresh_color4);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        //刷新接口
                        mList = WenZhangDBHelper.getInstance(getActivity()).getMessageInfoList();

                    }
                }).start();
                mSwipeRefreshLayout.setRefreshing(false);
                self_recycleViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected int getFragmentID() {
        return R.layout.self_recycleview;
    }

    @Override
    protected void initFragment() {
        initRecycleView();
        initRefresh();
    }

    private void initRecycleView() {
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        //初始化数据
        initData();
        self_recycleViewAdapter = new Self_WenZhangRecycleViewAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(self_recycleViewAdapter);
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(16);
        mRecyclerView.addItemDecoration(spacesItemDecoration);
        initRecycleViewListener();
    }

    private void initRecycleViewListener() {
        self_recycleViewAdapter.setOnClickListener(new Self_WenZhangRecycleViewAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int postion) {
                String shangPin = mList.get(postion).getUrl();
                Intent intent = new Intent(getActivity(), QingdanSecondActivity.class);
                intent.putExtra("event_id", shangPin);
                startActivity(intent);
            }

            @Override
            public void ItemLongClickListener(View view, final int postion) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("是否删除")
                        .setMessage("主人!我不想离开您")
                        .setPositiveButton("残忍抛弃", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            WenZhangDBHelper.getInstance(getActivity()).deleteMessageInfoList(mList.get(postion).getId());
                                            mList.remove(postion);
                                        }
                                    }).start();
                                    self_recycleViewAdapter.notifyDataSetChanged();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }).show();
            }
        });

    }

    private void initData() {
//        删除所有数据
//        WenZhangDBHelper.getInstance(getActivity()).clearMessageInfo();
//
        WenZhang wenZhang = new WenZhang();
        wenZhang.setAddLove("9999");
        wenZhang.setImage("http://img1.imgtn.bdimg.com/it/u=3444612337,3844090186&fm=21&gp=0.jpg");
        wenZhang.setTitle("你好");
        wenZhang.setAddSee("199");
        wenZhang.setUrl("http://img5.imgtn.bdimg.com/it/u=1002453751,940470370&fm=21&gp=0.jpg");
        WenZhang wenZhan2g = new WenZhang();
        wenZhan2g.setAddLove("1999");
        wenZhan2g.setImage("http://img4.imgtn.bdimg.com/it/u=1425972139,1057908849&fm=21&gp=0.jpg");
        wenZhan2g.setTitle("你好");
        wenZhan2g.setAddSee("199");
        wenZhan2g.setUrl("http://img4.imgtn.bdimg.com/it/u=1425972139,1057908849&fm=21&gp=0.jpg");
////        WenZhang wenZhan3g = new WenZhang();
//        wenZhan3g.setAddLove("1999");
//        wenZhan3g.setImage("http://img4.imgtn.bdimg.com/it/u=1425972139,1057908849&fm=21&gp=0.jpg");
//        wenZhan3g.setTitle("你好");
//        wenZhan3g.setAddSee("199");
////        wenZhan3g.setUrl("http://img4.imgtn.bdimg.com/it/u=1425972139,1057908849&fm=21&gp=0.jpg");
        WenZhangDBHelper.getInstance(getActivity())
                .addToMessageInfoTable(wenZhang);
        WenZhangDBHelper.getInstance(getActivity())
                .addToMessageInfoTable(wenZhan2g);
//        WenZhangDBHelper.getInstance(getActivity())
//                .addToMessageInfoTable(wenZhan3g);
        mList = WenZhangDBHelper.getInstance(getActivity()).getMessageInfoList();


    }

    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        private SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.top = space;
            }
        }
    }


}
