package com.example.houshuai.qingdan.shopcar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Dufei on 2016/7/11.
 */

public class QingdanThridCommentListView extends ListView {

    public QingdanThridCommentListView(Context context) {
        super(context);
    }

    public QingdanThridCommentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QingdanThridCommentListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }



}

