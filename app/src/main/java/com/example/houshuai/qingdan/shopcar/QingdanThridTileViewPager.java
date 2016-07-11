package com.example.houshuai.qingdan.shopcar;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Dufei on 2016/7/11.
 */

public class QingdanThridTileViewPager extends ViewPager {

    public QingdanThridTileViewPager(Context context) {
        super(context);
    }

    public QingdanThridTileViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        }  catch (IllegalArgumentException e) {
            //不理会
            return false;
        }catch(ArrayIndexOutOfBoundsException e ){
            //不理会
            return false;
        }
    }

}
