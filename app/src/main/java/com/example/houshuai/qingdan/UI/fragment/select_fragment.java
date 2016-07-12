package com.example.houshuai.qingdan.UI.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.select_details_activity;
import com.example.houshuai.qingdan.bean.javaBean;
import com.example.houshuai.qingdan.utils.sparse;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by lihao on 2016/7/6.
 */
public class select_fragment extends Fragment{

    private Bundle arguments;
    private String modleString;
    private ListView lv_id;
    private MyAdapter adapter;
    private javaBean.DataBean.zongLeiBieBean chufangbean;
    private javaBean javaBeans;
    private List<javaBean.DataBean.zongLeiBieBean> categories;
    private javaBean.DataBean.zongLeiBieBean mealbean;
    private javaBean.DataBean.zongLeiBieBean homebean;
    private javaBean.DataBean.zongLeiBieBean personalbean;
    private javaBean.DataBean.zongLeiBieBean babybean;
    private javaBean.DataBean.zongLeiBieBean sportbean;
    private javaBean.DataBean.zongLeiBieBean shumabean;
    private javaBean.DataBean.zongLeiBieBean planebean;
    private javaBean.DataBean.zongLeiBieBean workbean;
    private javaBean.DataBean.zongLeiBieBean petbean;
    private javaBean.DataBean.zongLeiBieBean bathroombean;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmemt_layout,container,false);
        //发现view里面的ListView
        lv_id = (ListView) view.findViewById(R.id.lv_id);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        arguments = getArguments();
        //获取传过来的值
        modleString = arguments.getString("modelString");
        Log.i("tags", "onCreate: "+modleString);
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            is =  getResources().getAssets().open("select_uri.txt");
            baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            String Strjson = new String(baos.toByteArray());
            //解析json数据
            javaBeans = sparse.parsegson(Strjson);
            //设计一个数据分析的方法
            fenxijava(javaBeans);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
       super.onCreate(savedInstanceState);
    }
    //数据分析方法
    private void fenxijava(javaBean javaBeans) {
        //获得databean的数据
        javaBean.DataBean data = javaBeans.getData();
        //从databean获得总类别的集合
        categories = data.getCategories();
        //测试：打出总类别的个数
        Log.i(TAG, "parsegson: "+ categories.size());
        //循环，取出里面的数据
        for(int i = 0; i< categories.size(); i++){
            //依次显示出里面的各个类别，比如厨房等
            javaBean.DataBean.zongLeiBieBean zongLeiBieBean = categories.get(i);
            //获取到厨房这个类里面的标题类的集合
            List<javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean> titlelist =
                    zongLeiBieBean.getChildren();
            for(int j=0;j<titlelist.size();j++){
                //依次显示出厨房类里面的各个标题类
                javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean biaoTiLeiBieBean
                        = titlelist.get(j);
                //取出刀剪这个类里面的各种刀的集合
                List<javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean> jutilist
                        = biaoTiLeiBieBean.getChildren();
                for(int k=0;k<jutilist.size();k++){
                    //依次显示出里面的各种刀
                    javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean
                            juTiPinPaiBean = jutilist.get(k);
                    //然后从上面提取你想要的数据
                    Log.i("TAG",juTiPinPaiBean.getSlug());
                }
            }
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //根据传过来的值得不同，给ListVIew设置不同的布局文件
        //准备数据源
        switch (modleString){
            case "厨房":
                //根据点击的不同，准备数据源，从网络上请求数据
                //JsonHttpUtils.downloadJson("");下载
                //准备自定义的适配器
                chufangbean =categories.get(0);
                adapter = new MyAdapter(getActivity(), chufangbean);
                break;
            case "餐酒":
                mealbean = categories.get(1);
                adapter = new MyAdapter(getActivity(), mealbean);
                break;
            case "家居":
                homebean = categories.get(2);
                adapter = new MyAdapter(getActivity(), homebean);
                break;
            case "个护":
                personalbean = categories.get(3);
                adapter = new MyAdapter(getActivity(), personalbean);
                break;
            case "母婴":
                babybean = categories.get(4);
                adapter = new MyAdapter(getActivity(), babybean);
                break;
            case "运动":
                sportbean = categories.get(5);
                adapter = new MyAdapter(getActivity(), sportbean);
                break;
            case "数码":
                shumabean = categories.get(6);
                adapter = new MyAdapter(getActivity(), shumabean);
                break;
            case "出行":
                planebean = categories.get(7);
                adapter = new MyAdapter(getActivity(), planebean);
                break;
            case "办公":
                workbean = categories.get(8);
                adapter = new MyAdapter(getActivity(), workbean);
                break;
            case "宠物":
                petbean = categories.get(9);
                adapter = new MyAdapter(getActivity(), petbean);
                break;
            case "卫浴":
                bathroombean = categories.get(10);
                adapter = new MyAdapter(getActivity(), bathroombean);
                break;
        }
        //绑定适配器
        lv_id.setAdapter(adapter);

        super.onActivityCreated(savedInstanceState);
    }
}
        //自定义适配器
        class MyAdapter extends BaseAdapter{
            private Context context;
            private javaBean.DataBean.zongLeiBieBean data;
            private final List<javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean> titlelist;

            public  MyAdapter(FragmentActivity activity, javaBean.DataBean.zongLeiBieBean data){
                    this.data=data;
                    this.context=activity;
                titlelist = data.getChildren();
            }
            @Override
            public int getCount() {
                if(titlelist.size()!=0){
                    return titlelist.size();//决定了ListView的长度,根据标题来决定条数
                }
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return titlelist.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int i, View convertView, ViewGroup viewGroup) {
                 ViewHolder viewHolder = null;
                if(convertView==null){
                    viewHolder=new ViewHolder();
                    convertView= LayoutInflater.from(context).inflate(R.layout.lv_kitchen_item,null);
                    viewHolder.ll_title_name_id= (LinearLayout) convertView.findViewById(R.id.ll_title_name_id);
                    viewHolder.dao_name_id= (TextView) convertView.findViewById(R.id.dao_name_id);
                    viewHolder.id_flowlayout= (TagFlowLayout) convertView.findViewById(R.id.id_flowlayout);
                    convertView.setTag(viewHolder);
                }else{
                    viewHolder= (ViewHolder) convertView.getTag();
                }
                //给item里面的标题赋值
                //依次显示出厨房类里面的各个标题类  例子：刀剪类
                javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean biaoTiLeiBieBean
                        = titlelist.get(i);
                //给标题赋值  刀剪类的名字
                viewHolder.dao_name_id.setText(biaoTiLeiBieBean.getName());
                ////给FlowLayout添加标签
                //取出刀剪这个类里面的各种刀的集合
                final List<javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean> jutilist
                        = biaoTiLeiBieBean.getChildren();
                final List<String> l=new LinkedList<>();
                for(int k=0;k<jutilist.size();k++){
                    //依次显示出里面的各种刀
                    javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean
                            juTiPinPaiBean = jutilist.get(k);
                    //然后从上面提取你想要的数据
                    juTiPinPaiBean.getName();//具体的类的名字
                    l.add(juTiPinPaiBean.getName());
                }
                final ViewHolder finalViewHolder = viewHolder;
                viewHolder.id_flowlayout.setAdapter(new TagAdapter<String>(l) {
                    @Override
                    public View getView(FlowLayout parent, int position, String s) {
                        TextView tv = (TextView) LayoutInflater.from(context).inflate(R.layout.tv,
                                finalViewHolder.id_flowlayout, false);
                        tv.setText(s);
                        return tv;
                    }
                });
                //给ListView的每个标题添加点击监听器
                viewHolder.ll_title_name_id.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //触发的事件
                       TextView names= (TextView) view.findViewById(R.id.dao_name_id);
                        String s= (String) names.getText();//取出标题的名字
                        for(javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean biaoTiLeiBieBeans:titlelist){
                            if(s.equals(biaoTiLeiBieBeans.getName())){
                                //得到这个标题类,然后将这个类跳转到指定的activity
                                Intent intent=new Intent(context,select_details_activity.class);
                                Bundle bundle=new Bundle();
                                bundle.putParcelable("aaaaa",biaoTiLeiBieBeans);
                                intent.putExtras(bundle);
                                intent.putExtra("类型","标题的");
                                context.startActivity(intent);
                            }
                        }
                    }
                });
                //给FlowLayout里面的每个小标签添加监听事件
                viewHolder.id_flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                    @Override
                    public boolean onTagClick(View view, int position, FlowLayout parent) {
                        //循环遍历当前的标题集合
                        for(javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean biaoTiLeiBieBean:titlelist){
                            //得到标题类里面的关于实体类的集合
                            List<javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean> jutilists
                                    = biaoTiLeiBieBean.getChildren();
                            //循环遍历实体类的适合
                            for(javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean juti:jutilist){
                                //如果实体类的名字和点击的标签的名字一致
                                if(juti.getName().equals(l.get(position))){
                                    //开始跳转
                                    Intent intent=new Intent(context,select_details_activity.class);
                                    Bundle bundle=new Bundle();
                                    bundle.putParcelable("aaaaa",juti);
                                    intent.putExtras(bundle);
                                    intent.putExtra("类型","具体的");
                                    context.startActivity(intent);
                                    //终止循环并且退出循环所在的方法
                                    return false;
                                }
                            }
                        }

                        return true;
                    }
                });
                return convertView;
            }
            @Override
            public int getItemViewType(int position) {
                return super.getItemViewType(position);
            }
            private  final  class ViewHolder{
                TextView dao_name_id;
                TagFlowLayout id_flowlayout;
                LinearLayout ll_title_name_id;
            }

        }
