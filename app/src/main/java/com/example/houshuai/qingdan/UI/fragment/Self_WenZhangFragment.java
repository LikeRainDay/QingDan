package com.example.houshuai.qingdan.UI.fragment;

import android.graphics.Rect;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.adapter.Self_WenZhangRecycleViewAdapter;
import com.example.houshuai.qingdan.greendao.WenZhang;
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
                        self_recycleViewAdapter.notifyDataSetChanged();
                    }
                }).start();
                mSwipeRefreshLayout.setRefreshing(false);
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

    }


    private void initData() {
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
