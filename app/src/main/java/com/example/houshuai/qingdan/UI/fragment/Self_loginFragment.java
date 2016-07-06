package com.example.houshuai.qingdan.UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.houshuai.qingdan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by HouShuai on 2016/7/6.
 */

public class Self_loginFragment extends Fragment implements View.OnClickListener {
    private FragmentManager manager;
    private boolean isPop;
    private LayoutInflater inflater;
    private RelativeLayout linearLayout;
    @BindView(R.id.self_callback)
    ImageView mbackImage;
    @BindView(R.id.textView4)
    TextView mQvHao;
    @BindView(R.id.editText)
    EditText mEditText_phone;

    public Self_loginFragment() {
        isPop = true;
    }

    private View createPopView() {
        FrameLayout parent = new FrameLayout(getActivity());
        parent.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.BOTTOM;
        linearLayout = (RelativeLayout) inflater.inflate(R.layout.self_islogin_pop, null);
        linearLayout.setLayoutParams(params);
        parent.addView(linearLayout);
        ButterKnife.bind(this, linearLayout);
        mbackImage.setOnClickListener(this);
        mQvHao.setOnClickListener(this);
        mEditText_phone.setOnClickListener(this);
        mEditText_msg.setOnClickListener(this);
        mYanZheng.setOnClickListener(this);
        mXiaYiBu.setOnClickListener(this);
        mZhuCe.setOnClickListener(this);
        mForgetPass.setOnClickListener(this);
        mQQ.setOnClickListener(this);
        mSina.setOnClickListener(this);
        mRenRen.setOnClickListener(this);
        return parent;
    }

    private ViewGroup parentView;
    private View popView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        parentView = (ViewGroup) getActivity().getWindow().getDecorView();
        popView = createPopView();
        parentView.addView(popView);
        linearLayout.startAnimation(createTranslationInAnimation());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private Animation createTranslationInAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 1, type, 0);
        an.setDuration(300);
        return an;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        linearLayout.startAnimation(createTranslationOutAnimation());

        popView.postDelayed(new Runnable() {
            @Override
            public void run() {
                parentView.removeView(popView);
                parentView = null;
                popView = null;
                inflater = null;
                linearLayout = null;
            }
        }, 300);
    }

    private Animation createTranslationOutAnimation() {
        int type = TranslateAnimation.RELATIVE_TO_SELF;
        TranslateAnimation an = new TranslateAnimation(type, 0, type, 0, type, 0, type, 1);
        an.setDuration(300);
        an.setFillAfter(true);
        return an;
    }

    @BindView(R.id.editText2)
    EditText mEditText_msg;
    @BindView(R.id.button2)
    Button mYanZheng;
    @BindView(R.id.button4)
    Button mXiaYiBu;
    @BindView(R.id.textView5)
    TextView mZhuCe;
    @BindView(R.id.textView6)
    TextView mForgetPass;
    @BindView(R.id.imageView8)
    ImageView mQQ;
    @BindView(R.id.imageView10)
    ImageView mSina;
    @BindView(R.id.imageView9)
    ImageView mRenRen;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // TODO: 2016/7/6  
            case R.id.self_callback:
//返回      
                getFragmentManager().popBackStack();
                break;
            case R.id.textView4:
//区号
                break;
            case R.id.editText:
//电话号码
                break;
            case R.id.editText2:
//短信
                break;
            case R.id.button2:
//获取验证码
                break;
            case R.id.button4:
//下一步
                break;
            case R.id.textView5:
//注册
                break;
            case R.id.textView6:
//忘记密码
                break;
            case R.id.imageView8:
//企鹅第三方
                break;
            case R.id.imageView10:
//新浪
                break;
            case R.id.imageView9:
//人人
                break;


        }
    }
}
