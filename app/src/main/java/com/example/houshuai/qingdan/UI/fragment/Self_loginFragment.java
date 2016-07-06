package com.example.houshuai.qingdan.UI.fragment;

import android.content.Context;
import android.content.Intent;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.view.UMFriendListener;

import java.util.Map;

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
    private UMShareAPI umShareAPI = null;

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
        SHARE_MEDIA platform = null;
        umShareAPI = UMShareAPI.get(getActivity());
        switch (view.getId()) {
            // TODO: 2016/7/6  
            case R.id.self_callback:
//返回    并关闭虚拟键盘
                InputMethodManager systemService = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (systemService!=null) {
                    systemService.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
                }

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
                platform = SHARE_MEDIA.QQ;
                break;
            case R.id.imageView10:
//新浪
                platform = SHARE_MEDIA.SINA;
                break;
            case R.id.imageView9:
//人人
                platform = SHARE_MEDIA.RENREN;
//                umShareAPI.deleteOauth(getActivity(), platform, umdelAuthListener);
                break;
        }
        umShareAPI.doOauthVerify(getActivity(), platform, umAuthListener);
        umShareAPI.getFriend(getActivity(), platform, umGetfriendListener);

    }

    /**
     * auth callback interface
     **/
    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getContext(), " 清除授权", Toast.LENGTH_SHORT).show();
            Log.d("user info", "user info:" + data.toString());
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getContext(), "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getContext(), "取消授权", Toast.LENGTH_SHORT).show();
        }
    };
    /**
     * auth callback interface
     **/
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getContext(), " 授权成功", Toast.LENGTH_SHORT).show();
            Log.d("user info", "user info:" + data.toString());
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getContext(), "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getContext(), "取消授权", Toast.LENGTH_SHORT).show();
        }
    };


    private UMFriendListener umGetfriendListener = new UMFriendListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, Object> data) {
            if (data != null) {
                Toast.makeText(getContext(), data.get("json").toString(), Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getContext(), "get fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getContext(), "get cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }
}
