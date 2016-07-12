package com.example.houshuai.qingdan.UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.houshuai.qingdan.R;

/**
 * 挑选
 * Created by HouShuai on 2016/7/5.
 */

public class TiaoXuanFramgment extends Fragment{

    private FragmentManager fragmentManager;
    private RadioGroup rg_id;
    private RadioButton rb_kitchen_id;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tiaoxuan_framgment,container,false);
        //思路：
        //初始化界面控件实例
        initView(view);
        //获取FragmentManager的实例
        fragmentManager = getActivity().getSupportFragmentManager();
        //关于RadioGroup的操作
        aboutRadioGroup();
        //第一次启动的时候，自动选择厨房
        rb_kitchen_id.setChecked(true);

        return view;
    }
    private void initView(View view) {
        rg_id = (RadioGroup)view.findViewById(R.id.rg_id);
        rb_kitchen_id = (RadioButton)view.findViewById(R.id.rb_kitchen_id);
    }
    private void aboutRadioGroup() {
        //给RadioGroup添加监听器
        rg_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //在监听器内部相应的方法中
                //根据选择，使用相对应的Fragment对应的视图，替换占位容器
                //开启事务
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Fragment fragment=new select_fragment();//测试类
                Bundle bundle=new Bundle();
                switch (i){
                    case R.id.rb_kitchen_id://厨房
                        bundle.putString("modelString","厨房");
                        break;
                    case R.id.rb_meal_id://餐酒
                        bundle.putString("modelString","餐酒");
                        break;
                    case R.id.rb_home_id://家居
                        bundle.putString("modelString","家居");
                        break;
                    case R.id.rb_personal_id://个护
                        bundle.putString("modelString","个护");
                        break;
                    case R.id.rb_baby_id://母婴
                        bundle.putString("modelString","母婴");
                        break;
                    case R.id.rb_sport_id://运动
                        bundle.putString("modelString","运动");
                        break;
                    case R.id.rb_shuma_id://数码
                        bundle.putString("modelString","数码");
                        break;
                    case R.id.rb_plane_id://出行
                        bundle.putString("modelString","出行");
                        break;
                    case R.id.rb_work_id://办公
                        bundle.putString("modelString","办公");
                        break;
                    case R.id.rb_pet_id://宠物
                        bundle.putString("modelString","宠物");
                        break;
                    case R.id.rb_bathroom_id://卫浴
                        bundle.putString("modelString","卫浴");
                        break;
                }
                fragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.frag_id,fragment);
                //提交事务
                fragmentTransaction.commit();
            }
        });
    }

}
