package com.example.houshuai.qingdan.utils;

import com.example.houshuai.qingdan.bean.javaBean;
import com.google.gson.Gson;

/**
 * Created by haohao on 2016/7/8.
 */

public class sparse {
    public static javaBean parsegson(String s){
        Gson gson=new Gson();
        //得到里面的所有的数据
        javaBean javaBeans = gson.fromJson(s,javaBean.class);

        return javaBeans;
    }


}
