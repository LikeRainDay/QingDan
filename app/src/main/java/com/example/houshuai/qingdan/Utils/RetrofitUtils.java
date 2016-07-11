package com.example.houshuai.qingdan.utils;

import com.example.houshuai.qingdan.inter.QingdanInter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiajie on 2016/7/10.
 */

public class RetrofitUtils {
    public static  QingdanInter initRetrofit(String baseUrl) {
        OkHttpClient client = OkHttp3Utils.getOkHttpSingletonInstance();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(QingdanInter.class);
    }
}
