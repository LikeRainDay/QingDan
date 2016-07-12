package com.example.houshuai.qingdan.utils;

import com.example.houshuai.qingdan.bean.typebean;
import com.google.gson.Gson;


/**
 * Created by haohao on 2016/7/9.
 */

public class typeparse {
    public static typebean parseType(String s){
        Gson gson=new Gson();
        //得到里面的所有的数据
        typebean type= gson.fromJson(s,typebean.class);
        return type;
    }
}
