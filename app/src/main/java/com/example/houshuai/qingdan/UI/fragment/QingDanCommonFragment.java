package com.example.houshuai.qingdan.UI.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.QingdanSecondActivity;
import com.example.houshuai.qingdan.adapter.Qingdan_list_Adapter2;
import com.example.houshuai.qingdan.bean.CategoryListBean;
import com.example.houshuai.qingdan.utils.OkHttp3Utils;
import com.example.houshuai.qingdan.adapter.Qingdan_list_Adapter;
import com.example.houshuai.qingdan.bean.Constant;
import com.example.houshuai.qingdan.bean.NewListBean;
import com.example.houshuai.qingdan.inter.QingdanInter;
import com.example.houshuai.qingdan.utils.RetrofitUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**分类展示的Fragment
 * Created by xiajie on 2016/7/6.
 */

public class QingDanCommonFragment extends Fragment {

    private String mType;
    private Activity mactivity;
    private QingdanInter serverInterface;
    private Call<NewListBean> call_result1;
    private Call<CategoryListBean> call_result2;
    private int index ;//
    private List<NewListBean.MzMartshowsBean> list1 ;//第一页数据源
    private List<CategoryListBean.MzMartshowsBean> list2;//
    private Qingdan_list_Adapter adapter;
    private Qingdan_list_Adapter2 adapter2;
    private PullToRefreshListView lv;
    private boolean isPullDownRefresh=true;//判断是下拉，还是上拉的标记
    private SimpleDateFormat mDateFormat = new SimpleDateFormat("MM-dd HH:mm");//日期格式
    private Date date;//上次刷新时间
    private String baseUrl;
    private String event_id;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mType = getArguments().getString("type");
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.qingdan_common_fragment, null);
        lv= (PullToRefreshListView) view.findViewById(R.id.qingdan_lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        index=1;
        date=new Date();
        mactivity = getActivity();
        if("news".equals(mType))
        {
            list1=new LinkedList<>();
            baseUrl=Constant.BASE_URL_NEW;
            serverInterface= RetrofitUtils.initRetrofit(baseUrl);
            adapter=new Qingdan_list_Adapter(list1,getActivity());
            getNewsListBean(serverInterface,index,true);
            //Log.i("TAG","第一次---list:"+list1.size());
            lv.setAdapter(adapter);
           adapter.reloadData(list1,true);
        }else {
            list2=new LinkedList<>();
            baseUrl=Constant.BASE_URL_CATEGORIES;
            serverInterface= RetrofitUtils.initRetrofit(baseUrl);
            adapter2=new Qingdan_list_Adapter2(list2,getActivity());
            getCategoryListBean(serverInterface,mType,index,true);
            lv.setAdapter(adapter2);
        }
        //设置当前上拉加载不可用
        lv.setPullToRefreshOverScrollEnabled(true);
        //滑到底部是否自动加载数据，这句话一定要加要不然"已经到底啦"显示不出来
        lv.setEmptyView(getActivity().getLayoutInflater().inflate(R.layout.qingdan_list_empty,null));
        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 Intent intent=new Intent(getActivity(), QingdanSecondActivity.class);
                Log.d("TAG", i+"------------------------------------");
                if ("news".equals(mType))
                {
                    event_id=list1.get(i-1).getEvent_id();
                }else {
                    event_id=list2.get(i-1).getEvent_id()+"";
                }
                intent.putExtra("event_id",event_id);
                Log.i("TAG","evend_id--->"+event_id);
                startActivity(intent);
            }
        });


        lv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                if(lv.isShownHeader())
                {
                    //设置刷新标签
                    lv.getLoadingLayoutProxy().setRefreshingLabel("正在刷新");
                    //设置下拉标签
                    lv.getLoadingLayoutProxy().setPullLabel("下拉刷新");
                    //设置释放标签
                    lv.getLoadingLayoutProxy().setReleaseLabel("释放开始刷新");
                    //设置上一次刷新的提示标签
                    lv.getLoadingLayoutProxy().setLastUpdatedLabel("上次更新时间:" + mDateFormat.format(date));
                      if ("news".equals(mType))
                    {
                        getNewsListBean(serverInterface,index,true);
                    }else {
                        getCategoryListBean(serverInterface,mType,index,true);
                    }

                }

                if(lv.isShownFooter())
                {
                    //设置刷新标签
                    lv.getLoadingLayoutProxy().setRefreshingLabel("正在加载");
                    //设置下拉标签
                    lv.getLoadingLayoutProxy().setPullLabel("上拉刷新");
                    //设置释放标签
                    lv.getLoadingLayoutProxy().setReleaseLabel("释放开始加载");
                    //设置上一次刷新的提示标签
                    lv.getLoadingLayoutProxy().setLastUpdatedLabel("上次加载时间:" + mDateFormat.format(date));
                    if ("news".equals(mType))
                    {
                        getNewsListBean(serverInterface,++index,false);
                    }else {
                        getCategoryListBean(serverInterface,mType,++index,false);
                    }

                }

            }
        });
    }


    private void getNewsListBean(QingdanInter serverInterface, int index, final boolean isClear)
    {
        Log.i("Tag","index----->"+index);
        call_result1 = serverInterface.getLastList(index);
        call_result1.enqueue(new Callback<NewListBean>() {
            @Override
            public void onResponse(Call<NewListBean> call, Response<NewListBean> response) {
                if (response.isSuccess() && response.body() != null) {
                    list1 = response.body().getMz_martshows();
                    adapter.reloadData(list1,isClear);
                    lv.onRefreshComplete();
                    Log.i("TAG","LIST---->"+list1.size()+"-------"+list1.get(0).getEvent_id());
                    date=new Date();
                }
            }
            @Override
            public void onFailure(Call<NewListBean> call, Throwable t) {

                Toast.makeText(mactivity, "网络异常，加载失败！", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getCategoryListBean(QingdanInter serverInterface, String mType, int index, final boolean isClear)
    {
        Log.i("Tag","index----->"+index);
        call_result2 = serverInterface.getFirstPageList(index,mType);
        call_result2.enqueue(new Callback<CategoryListBean>() {
            @Override
            public void onResponse(Call<CategoryListBean> call, Response<CategoryListBean> response) {
                if (response.isSuccess() && response.body() != null) {
                    list2 = response.body().getMz_martshows();
                    adapter2.reloadData(list2,isClear);
                    lv.onRefreshComplete();
                    Log.i("TAG","LIST---->"+list2.size()+"-------"+list2.get(0).getEvent_id());
                    date=new Date();
                }
            }
            @Override
            public void onFailure(Call<CategoryListBean> call, Throwable t) {

                Toast.makeText(mactivity, "网络异常，加载失败！", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
