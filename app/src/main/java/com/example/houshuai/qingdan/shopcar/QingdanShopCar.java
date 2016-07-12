package com.example.houshuai.qingdan.shopcar;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.houshuai.qingdan.R;

import java.util.HashMap;

public class QingdanShopCar extends AppCompatActivity implements IBtnCallListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qingdan_shop_car);
        show();
        getSaveData();
    }
    /** 得到保存的购物车数据 */
    private void getSaveData() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        SharedPreferences sp = getSharedPreferences("SAVE_CART", Context.MODE_PRIVATE);
        int size = sp.getInt("ArrayCart_size", 0);
        for (int i = 0; i < size; i++) {
            hashMap.put("type", sp.getString("ArrayCart_type_" + i, ""));
            hashMap.put("color", sp.getString("ArrayCart_color_" + i, ""));
            hashMap.put("num", sp.getString("ArrayCart_num_" + i, ""));
            hashMap.put("price",sp.getString("ArrayCart_price_"+i,""));
            hashMap.put("imgUrl",sp.getString("ArrayCart_imgUrl_"+i,""));
            hashMap.put("name",sp.getString("ArrayCart_name_"+i,""));
            QingdanShopingCarData.arrayList_cart.add(hashMap);
        }




    }

    private void show() {
        //1，得到Fragment管理器对象
        FragmentManager fManager = getSupportFragmentManager();

        //2，开始Fragment的事务处理
        FragmentTransaction transaction = fManager.beginTransaction();
        Cart_F cart_F=new Cart_F();
        transaction.replace(R.id.cart_f,cart_F);
        //5，提交事务
        transaction.commit();

    }
//方法未实现
    @Override
    public void transferMsg() {

    }
}
