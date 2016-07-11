package com.example.houshuai.qingdan.UI.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.FormView;
import com.example.houshuai.qingdan.utils.LoginUtil;
import com.example.houshuai.qingdan.utils.ThridLoginUtil;
import com.umeng.socialize.UMShareAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import static com.example.houshuai.qingdan.R.id.buttonMsg;
import static com.example.houshuai.qingdan.R.id.edit1;
import static com.example.houshuai.qingdan.R.id.edit2;
import static com.example.houshuai.qingdan.R.id.welcom_qvhao;
import static com.example.houshuai.qingdan.UI.Activity.WelcomeMovieActivity.InputType.LOGIN;
import static com.example.houshuai.qingdan.UI.Activity.WelcomeMovieActivity.InputType.SIGN_UP;

/**
 * Created by HouShuai on 2016/7/8.
 */

public class WelcomeMovieActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String VIDEO_NAME = "welcome_video.mp4";

    private VideoView mVideoView;

    private InputType inputType = InputType.NONE;

    private Button buttonLeft, buttonRight;

    private FormView formView;
    private LinearLayout Self_FormView_Welcome;

    private ViewGroup contianer;

    private TextView appName;
    private EditText mUserName;
    private EditText mUserPass;
    private App application;
    private Button buttonThird;
    private EditText egist_edit1;
    private EditText egist_edit2;
    private EditText egist_edit3;
    private TextView mQvhao;
    private Button mYanZheng;
    private boolean isOK;
    private String mPhone;
    private String mPass;
    private UMShareAPI umShareAPI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        application = (App) getApplication();

        initIsShow();
        super.onCreate(savedInstanceState);
        LoginUtil.windowSettings(this);
        setContentView(R.layout.welcomview);
        initsetIsFalse();
        findView();
        initView();
        yanzheng();
        File videoFile = getFileStreamPath(VIDEO_NAME);
        if (!videoFile.exists()) {
            videoFile = copyVideoFile();
        }
        playVideo(videoFile);
        playAnim();

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }

    private void initsetIsFalse() {
        SharedPreferences welcomeview = getSharedPreferences("welcomeview", MODE_PRIVATE);
        SharedPreferences.Editor edit = welcomeview.edit();
        edit.putBoolean("isShow", false);
        edit.commit();
    }

    private void initIsShow() {
        boolean mIsLogin = application.mIsLogin;
        if (mIsLogin == true) {
            SharedPreferences welcomeview = getSharedPreferences("welcomeview", MODE_PRIVATE);
            boolean isShow = welcomeview.getBoolean("isShow", true);
            if (!isShow) {
                toMainActivity();
            }
        }
    }

    private void toMainActivity() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
        finish();
    }


    private void findView() {
        mVideoView = (VideoView) findViewById(R.id.videoView);
        buttonLeft = (Button) findViewById(R.id.buttonLeft);
        buttonRight = (Button) findViewById(R.id.buttonRight);
        contianer = (ViewGroup) findViewById(R.id.container);
        formView = (FormView) findViewById(R.id.formView);
        Self_FormView_Welcome = (LinearLayout) findViewById(R.id.regist_form_view);
        appName = (TextView) findViewById(R.id.appName);
        buttonThird = (Button) findViewById(R.id.buttonThird);
        mUserName = (EditText) formView.findViewById(edit1);
        mUserPass = (EditText) formView.findViewById(edit2);

        egist_edit1 = (EditText) Self_FormView_Welcome.findViewById(R.id.self_edit1);
        egist_edit2 = (EditText) Self_FormView_Welcome.findViewById(R.id.self_edit2);
        egist_edit3 = (EditText) Self_FormView_Welcome.findViewById(R.id.self_edit3);
        mQvhao = (TextView) Self_FormView_Welcome.findViewById(welcom_qvhao);
        mYanZheng = (Button) Self_FormView_Welcome.findViewById(buttonMsg);


        formView.post(new Runnable() {
            @Override
            public void run() {
                int delta = formView.getTop() + formView.getHeight();
                formView.setTranslationY(-1 * delta);
            }
        });
        Self_FormView_Welcome.post(new Runnable() {
            @Override
            public void run() {
                int delta = Self_FormView_Welcome.getTop() + Self_FormView_Welcome.getHeight();
                Self_FormView_Welcome.setTranslationY(-1 * delta);
            }
        });
        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                umShareAPI = ThridLoginUtil.startAuto(WelcomeMovieActivity.this);
            }
        });
        mYanZheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = egist_edit1.getText().toString().trim();
                String pass = egist_edit2.getText().toString().trim();
                String msg = egist_edit3.getText().toString().trim();
                Pattern compile = Pattern.compile("^((\\(d{3}\\))|(\\d{3}\\-))?13[0-9]\\d{8}|15[89]\\d{8}|18[0-9]\\d{8}");
                Matcher matcher = compile.matcher(phone);
                if (matcher.find()) {
                    //获取验证码
                    getMsgNumber();
                    mPhone = phone;
                } else {
                    Toast.makeText(WelcomeMovieActivity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mQvhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(WelcomeMovieActivity.this, CountryActivity.class);
                startActivityForResult(intent, 12);
            }
        });
    }

    private void yanzheng() {
        SMSSDK.registerEventHandler(new EventHandler() {
            @Override
            public void afterEvent(int event, int result, java.lang.Object data) {
                super.afterEvent(event, result, data);
                Log.d("aaa", event + "<afterEvent>" + result + "," + data);

                Log.d("aaa", event + "<afterEvent>" + result + ",myLooper=" + Looper.myLooper());
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    if (result == SMSSDK.RESULT_COMPLETE) {
                        //成功后跳转
                        Log.d("aaa", event + "<afterEvent>" + result + ",校验成功");
                        isOK = true;
                        int pass = (int) (Math.random() * 99999999);
                        mPass = String.valueOf(pass);
                        Toast.makeText(WelcomeMovieActivity.this, pass, Toast.LENGTH_LONG).show();

                    } else {
                        Log.d("aaa", event + "<afterEvent>" + result + ",校验失败");
                    }
                }
            }
        });
    }

    private void initView() {

        buttonRight.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);
    }

    private void playVideo(File videoFile) {
        mVideoView.setVideoPath(videoFile.getPath());
        mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });
    }

    private void playAnim() {
        ObjectAnimator anim = ObjectAnimator.ofFloat(appName, "alpha", 0, 1);
        anim.setDuration(4000);
        anim.setRepeatCount(1);
        anim.setRepeatMode(ObjectAnimator.REVERSE);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                appName.setVisibility(View.INVISIBLE);
            }
        });
    }

    @NonNull
    private File copyVideoFile() {
        File videoFile;
        try {
            FileOutputStream fos = openFileOutput(VIDEO_NAME, MODE_PRIVATE);
            InputStream in = getResources().openRawResource(R.raw.welcome_video);
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = in.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        videoFile = getFileStreamPath(VIDEO_NAME);
        if (!videoFile.exists())
            throw new RuntimeException("video file has problem, are you sure you have welcome_video.mp4 in res/raw folder?");
        return videoFile;
    }

    @Override
    public void onClick(View view) {
        int delta = formView.getTop() + formView.getHeight();
        int delta2 = Self_FormView_Welcome.getTop() + Self_FormView_Welcome.getHeight();
        switch (inputType) {
            case NONE:


                if (view == buttonLeft) {
                    formView.animate().translationY(0).alpha(1).setDuration(500).start();
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                    inputType = LOGIN;
                    buttonLeft.setText(R.string.button_confirm_login);
                    buttonRight.setText(R.string.button_cancel_login);

                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(0).alpha(1).setDuration(500).start();
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                    inputType = SIGN_UP;
                    buttonLeft.setText(R.string.button_confirm_signup);
                    buttonRight.setText(R.string.button_cancel_signup);
                }

                break;
            case LOGIN:
                if (view == buttonLeft) {
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                    //denglu
                    String userName = mUserName.getText().toString().trim();
                    String userPass = mUserPass.getText().toString().trim();
                    boolean has = LoginUtil.newNameEqualPass(application, userName, userPass);
                    if (userName == "" || userPass == "" || !has) {
                        Toast.makeText(this, "用户不存在,请注册", Toast.LENGTH_SHORT).show();
                    } else {
                        toMainActivity();
                    }

                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();

                }
                inputType = InputType.NONE;
                buttonLeft.setText(R.string.button_login);
                buttonRight.setText(R.string.button_signup);
                break;
            case SIGN_UP:
                if (view == buttonLeft) {



                    String nincheng = egist_edit2.getText().toString().trim();
                    Pattern nameCompile = Pattern.compile("^[\\u2E80-\\u9FFF]{2,5}$");
                    Matcher nameMatcher = nameCompile.matcher(nincheng);
                    if (nameMatcher.find() &&isOK) {
                        application.setMySharePerference(mPhone, mPhone, mPass, "", "", nincheng);
                        application.setIsLoginSharedPreferences(true, mPhone);
                        toMainActivity();
                    } else {
                        Toast.makeText(this, "输入有误,昵称只能为中文", Toast.LENGTH_SHORT).show();
                    }
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                }
                inputType = InputType.NONE;
                buttonLeft.setText(R.string.button_login);
                buttonRight.setText(R.string.button_signup);
                break;
        }
    }

    private void getMsgNumber() {
        WelcomeMovieActivity.TimeCount time = new WelcomeMovieActivity.TimeCount(60000, 1000);
        time.start();//开始计时
        SMSSDK.getVerificationCode(mQvhao.getText().toString().trim().substring(1), egist_edit1.getText().toString().trim(), new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String s, String s1) {
                return false;
            }
        });
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        }

        @Override
        public void onFinish() {//计时完毕时触发
            mYanZheng.setText("重新验证");
            mYanZheng.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            mYanZheng.setClickable(false);
            mYanZheng.setText(millisUntilFinished / 1000 + "秒");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        umShareAPI.onActivityResult(requestCode, resultCode, data);
    }

    enum InputType {
        NONE, LOGIN, SIGN_UP;
    }

}
