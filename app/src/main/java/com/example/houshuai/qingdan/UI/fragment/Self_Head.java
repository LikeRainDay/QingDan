package com.example.houshuai.qingdan.UI.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.Base.BaseFragment;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.Self_Settings;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

import butterknife.BindView;

/**
 * Created by HouShuai on 2016/7/5.
 */

public class Self_Head extends BaseFragment {


    @BindView(R.id.self_image)
    ImageView mImageView;
    @BindView(R.id.textView)
    TextView mTextView;
    private App application;


    @Override
    protected int getFragmentID() {
        return R.layout.self_heard;
    }

    @Override
    protected void initFragment() {
        application = (App) getActivity().getApplication();
        if (application.mIsLogin) {
            initView();
            onMyClickListener();
        }
    }

    private void initView() {
        List<String> mySharePerference = application.getMySharePerference(application.mID);
        Picasso.with(mContext)
                .load(new File(mySharePerference.get(2)))
                .placeholder(R.mipmap.llist_img_default_avatar)
                .into(mImageView);
        mTextView.setText(mySharePerference.get(4));

    }

    private void onMyClickListener() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.self_image) {
                    Intent intent = new Intent(getActivity(), Self_Settings.class);
                    startActivity(intent);
                }
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.textView) {

                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
