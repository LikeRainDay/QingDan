package com.example.houshuai.qingdan.UI.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        application = (App) getApplication();

        initIsShow();
        super.onCreate(savedInstanceState);
        LoginUtil.windowSettings(this);
        setContentView(com.example.houshuai.qingdan.R.layout.welcomview);
        initsetIsFalse();
        findView();
        initView();
        File videoFile = getFileStreamPath(VIDEO_NAME);
        if (!videoFile.exists()) {
            videoFile = copyVideoFile();
        }
        playVideo(videoFile);
        playAnim();
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
                // TODO: 2016/7/9 第三方

                Toast.makeText(WelcomeMovieActivity.this, "第三方", Toast.LENGTH_LONG).show();
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
    protected void onDestroy() {
        super.onDestroy();
        mVideoView.stopPlayback();
    }

    @Override
    public void onClick(View view) {
        int delta = formView.getTop() + formView.getHeight();
        int delta2 = Self_FormView_Welcome.getTop() + Self_FormView_Welcome.getHeight();
        switch (inputType) {
            case NONE:


                if (view == buttonLeft) {
                    formView.animate().translationY(0).alpha(1).setDuration(500).start();
                    inputType = LOGIN;
                    buttonLeft.setText(R.string.button_confirm_login);
                    buttonRight.setText(R.string.button_cancel_login);

                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(0).alpha(1).setDuration(500).start();
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
                    boolean has = new LoginUtil(application).nameEqualPass(userName, userPass);
                    if (!has) {
                        Toast.makeText(this, "用户不存在,请注册", Toast.LENGTH_SHORT).show();
                    } else {
                        toMainActivity();
                    }

                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                }
                inputType = InputType.NONE;
                buttonLeft.setText(R.string.button_login);
                buttonRight.setText(R.string.button_signup);
                break;
            case SIGN_UP:


                if (view == buttonLeft) {
                    formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                    // TODO: 2016/7/8 zhuce
                    toMainActivity();
                } else if (view == buttonRight) {
                    Self_FormView_Welcome.animate().translationY(-1 * delta2).alpha(0).setDuration(500).start();
                }
                inputType = InputType.NONE;
                buttonLeft.setText(R.string.button_login);
                buttonRight.setText(R.string.button_signup);
                break;
        }
    }

    enum InputType {
        NONE, LOGIN, SIGN_UP;
    }
}
