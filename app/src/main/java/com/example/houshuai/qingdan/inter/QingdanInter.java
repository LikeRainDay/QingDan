package com.example.houshuai.qingdan.inter;



import com.example.houshuai.qingdan.bean.CategoryListBean;
import com.example.houshuai.qingdan.bean.NewListBean;
import com.example.houshuai.qingdan.bean.ZhuanchangBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import static com.renn.rennsdk.RennRequest.Method.GET;

/**访问网络获取数据的服务接口
 * Created by xiajie on 2016/7/7.
 */

public interface QingdanInter {

    @GET("{index}-20-0-0-1-0.html?package=mizhe")
    Call<NewListBean> getLastList(@Path("index") int index);

    @GET("{index}-20-{type}-1.html?package=mizhe")
    Call<CategoryListBean> getFirstPageList(@Path("index") int index, @Path("type") String type);
    @GET("{event_id}-1-40-hot-1--0-0-.html?package=mizhe&&user_label=1")
    Call<ZhuanchangBean> getZhuanchangInfo(@Path("event_id")String event_id);

}
