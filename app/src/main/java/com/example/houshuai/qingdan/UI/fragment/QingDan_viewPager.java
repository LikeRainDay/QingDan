package com.example.houshuai.qingdan.UI.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * 操作模块的viewpager
 * Created by HouShuai on 2016/7/6.
 */

public class QingDan_viewPager extends BaseFragment {
    @BindView(R.id.qingdan_viwpager)
    ViewPager mAutoScrollViewPager;
    //伪数据
    private int[] picViewPager = {R.mipmap.bg_6, R.mipmap.bg_7, R.mipmap.bg_8, R.mipmap.bg_9, R.mipmap.bg_10};

    private List<ImageView> ds;
    @Override
    protected int getFragmentID() {
        return R.layout.qingdan_viewpager;
    }

    @Override
    protected void initFragment() {
    ds=new LinkedList<>();
        for (int i=0;i<picViewPager.length;i++)
        {
            ImageView iv=new ImageView(getActivity());
            iv.setImageResource(picViewPager[i]);
            ds.add(iv);
        }
        mAutoScrollViewPager.setAdapter(new MyAdapter());

    }

  private final class MyAdapter extends PagerAdapter{

      @Override
      public int getCount() {
          return ds.size();
      }

      @Override
      public boolean isViewFromObject(View view, Object object) {
          return view==object;
      }

      @Override
      public Object instantiateItem(ViewGroup container, int position) {
          ImageView iv=ds.get(position);
          container.addView(iv);
          return iv;
      }

      @Override
      public void destroyItem(ViewGroup container, int position, Object object) {
          container.removeView(ds.get(position));
      }
  }
}
