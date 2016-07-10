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

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Activity.CountryActivity;
import com.example.houshuai.qingdan.UI.Activity.MainActivity;
import com.example.houshuai.qingdan.UI.Activity.Self_ZhuCeActivity;
import com.example.houshuai.qingdan.inter.UmLoginInter;
import com.example.houshuai.qingdan.utils.LoginUtil;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.Activity.RESULT_OK;
import static com.example.houshuai.qingdan.R.id.textView4;

/**
 * Created by HouShuai on 2016/7/6.
 */

public class Self_loginFragment extends Fragment implements View.OnClickListener {
    private FragmentManager manager;
    private boolean isPop;
    private UMShareAPI umShareAPI = null;
    private LayoutInflater inflater;
    private RelativeLayout linearLayout;
    private boolean isAuth = false;
    Intent intent = null;
    @BindView(R.id.self_callback)
    ImageView mbackImage;
    @BindView(textView4)
    TextView mQvHao;
    @BindView(R.id.editText)
    EditText mEditText_phone;
    @BindView(R.id.editText2)
    EditText mEditText_msg;
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
    private App application;
    private UmLoginInter mUmLoginInter;

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


    @Override
    public void onClick(View view) {
        application = (App) getActivity().getApplication();
        SHARE_MEDIA platform = null;
        umShareAPI = UMShareAPI.get(getActivity());
        switch (view.getId()) {
            // TODO: 2016/7/6


            case R.id.self_callback:
//返回    并关闭虚拟键盘
                InputMethodManager systemService = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (systemService != null) {
                    systemService.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
                }
                getFragmentManager().popBackStack();
                break;
            case textView4:
//区号

                Intent intent = new Intent(getActivity(), CountryActivity.class);
                startActivityForResult(intent, 12);


                break;
            case R.id.button4:
//登录

                String name = mEditText_phone.getText().toString().trim();
                String pass = mEditText_msg.getText().toString().trim();
//                mQvHao.getText().toString().trim();
                boolean b = LoginUtil.newNameEqualPass(application, name, pass);
                if (b) {
                    //登录成功
                    application.setIsLoginSharedPreferences(true, name);
                    application.checkIsLogin();
                    Intent m = new Intent(getActivity(), MainActivity.class);
                    m.putExtra("inner_login", true);
                    startActivity(m);
                    getFragmentManager().popBackStack();
                } else {
                    Toast.makeText(getActivity(), "账号密码不正确,请核对后登录", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.textView5:
//注册
                intent = new Intent(getActivity(), Self_ZhuCeActivity.class);
                startActivity(intent);
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

                break;
        }

        if (!isAuth) {
            //取消授权
            umShareAPI.deleteOauth(getActivity(), platform, umdelAuthListener);
            isAuth = true;
            return;
        }
        umShareAPI.doOauthVerify(getActivity(), platform, umAuthListener);
        isAuth = false;
    }

    /**
     * auth callback interface
     **/
    private UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getContext(), " 清除授权", Toast.LENGTH_SHORT).show();
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
            umShareAPI.getPlatformInfo(getActivity(), platform, umGetfriendListener);
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


    private UMAuthListener umGetfriendListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> data) {
            if (data != null) {
                String screen_name = data.get("screen_name");
                String profile_image_url = data.get("profile_image_url");
                String openid = data.get("openid");
                application.setIsLoginSharedPreferences(true, openid);
                application.setMySharePerference(openid, "third", openid, profile_image_url, "", screen_name);
                application.checkIsLogin();
                getFragmentManager().popBackStack();

            }
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 12:
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    String countryNumber = bundle.getString("countryNumber");
                    mQvHao.setText(countryNumber);
                }
                break;

            default:
                break;
        }


    }
}
