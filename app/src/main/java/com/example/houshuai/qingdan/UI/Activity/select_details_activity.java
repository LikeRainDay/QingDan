package com.example.houshuai.qingdan.UI.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.bean.javaBean;
import com.example.houshuai.qingdan.bean.typebean;
import com.example.houshuai.qingdan.utils.typeparse;

import org.xutils.x;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class select_details_activity extends AppCompatActivity {

    private ImageView iv_juti_id;
    private TextView tv_title_id;
    private TextView tv_jieshao_id;
    private TextView tv_biaotibar_id;
    private ImageView iv_back_id;
    private String s;
    private ListView lv_cate_id;
    private String stringjson1;
    private String stringjson2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_details_layout);
        //得到传过来的
        initView();//发现界面控件实例
        Intent intent = getIntent();
        s = intent.getStringExtra("类型");//获取传过来的对象的类型
        if(s.equals("标题的")){
            //根据类型，将对象进行转型
            javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean bean=intent.getParcelableExtra("aaaaa");
            x.image().bind(iv_juti_id,bean.getCoverImageUrl());
            tv_title_id.setText(bean.getName());
            tv_jieshao_id.setText(bean.getExcerpt());
            tv_biaotibar_id.setText(bean.getName());
            //获取对象的slug
            String slug = bean.getSlug();
            //根据对象的slug去获取想对应json数据
            stringjson1 = openfile(slug);//空指针异常
        }else if(s.equals("具体的")){
            javaBean.DataBean.zongLeiBieBean.biaoTiLeiBieBean.juTiPinPaiBean bean=intent.getParcelableExtra("aaaaa");
            x.image().bind(iv_juti_id,bean.getCoverImageUrl());
            tv_title_id.setText(bean.getName());
            tv_jieshao_id.setText(bean.getExcerpt());
            tv_biaotibar_id.setText(bean.getName());
            String slug = bean.getSlug();
            stringjson2 = openfile(slug);
        }
        //填充listview
        aboutlistView();

   }
    //根据文件的slug来获取相对应的json格式的数据
    private String  openfile(String sulg) {
        ByteArrayOutputStream baos = null;
        InputStream is = null;
        try {
            is =getApplicationContext().getResources().getAssets().open("categories/"+sulg+"/things");//获取文件
            baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  new String(baos.toByteArray());//空指针异常
    }

    public void aboutlistView() {
        //将json数据进行解析
        typebean tbean=null;
        if(s.equals("标题的")){
             tbean = typeparse.parseType(stringjson1);//获得了每个具体的类的信息
        }else if(s.equals("具体的")){
             tbean = typeparse.parseType(stringjson2);//获得了每个具体的类的信息

        }
        //数据分析类
        //准备数据源
        final List<typebean.DataBean.ThingsBean> thingsBeanList = fenxijson(tbean);

        ArticleAdapter adapter=new ArticleAdapter(getApplicationContext(),thingsBeanList);
        //绑定适配器
        lv_cate_id.setAdapter(adapter);
        //设置点击监听事件
        lv_cate_id.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到详情activity
                typebean.DataBean.ThingsBean thingsBean = thingsBeanList.get(i);
                Intent intent=new Intent(select_details_activity.this,select_product_Activity.class);

                Bundle bundle=new Bundle();
                bundle.putSerializable("thingsbean",thingsBean);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });



    }

    private List<typebean.DataBean.ThingsBean> fenxijson(typebean tbean) {
        //获取里面的dataBean
        typebean.DataBean dataBean = tbean.getData();
        //从databean里面获取里面的实体的类的集合
        List<typebean.DataBean.ThingsBean> things = dataBean.getThings();
        return things;
    }

    private void initView() {
        iv_juti_id = (ImageView) findViewById(R.id.iv_juti_id);
        tv_title_id = (TextView) findViewById(R.id.tv_title_id);
        tv_jieshao_id = (TextView) findViewById(R.id.tv_jieshao_id);
        tv_biaotibar_id = (TextView) findViewById(R.id.tv_biaotibar_id);
        iv_back_id = (ImageView) findViewById(R.id.iv_back_id);
        //发现ListView
        lv_cate_id = (ListView) findViewById(R.id.lv_cate_id);
        iv_back_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    //自定义视频的adapter
    public class ArticleAdapter extends BaseAdapter {
        private Context context;
        private List<typebean.DataBean.ThingsBean> list;

        public ArticleAdapter(Context context, List<typebean.DataBean.ThingsBean> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public int getCount() {
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.select_type_details_item, null);
                holder.iv_type_id = (ImageView) convertView.findViewById(R.id.iv_type_id);
                holder.tv_brand_name_id = (TextView) convertView.findViewById(R.id.tv_brand_name_id);
                holder.tv_thing_name_id = (TextView) convertView.findViewById(R.id.tv_thing_name_id);
                holder.tv_price_id = (TextView) convertView.findViewById(R.id.tv_price_id);
                holder.tv_likecount_id = (TextView) convertView.findViewById(R.id.tv_likecount_id);
                //设置标签
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //进行赋值
            x.image().bind(holder.iv_type_id,list.get(position).getImageUrls().get(0));
            holder.tv_brand_name_id.setText(list.get(position).getBrand().getName());
            holder.tv_thing_name_id.setText(list.get(position).getName());
            holder.tv_price_id.setText(list.get(position).getPrice());
            holder.tv_likecount_id.setText(list.get(position).getLikeCount()+"");//资源没有发现异常
            /* 对图片进行赋值 */
            return convertView;
        }

        private final class ViewHolder {
            ImageView iv_type_id;
            TextView tv_brand_name_id;
            TextView tv_thing_name_id;
            TextView tv_price_id;
            TextView tv_likecount_id;
        }
        }
    }
