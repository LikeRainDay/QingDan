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

    private ViewGroup contianer;

    private TextView appName;
    private EditText mUserName;
    private EditText mUserPass;
    private App application;


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
        mVideoView = (VideoView) findViewById(com.example.houshuai.qingdan.R.id.videoView);
        buttonLeft = (Button) findViewById(com.example.houshuai.qingdan.R.id.buttonLeft);
        buttonRight = (Button) findViewById(com.example.houshuai.qingdan.R.id.buttonRight);
        contianer = (ViewGroup) findViewById(com.example.houshuai.qingdan.R.id.container);
        formView = (FormView) findViewById(com.example.houshuai.qingdan.R.id.formView);
        appName = (TextView) findViewById(com.example.houshuai.qingdan.R.id.appName);
        mUserName = (EditText) formView.findViewById(R.id.edit1);
        mUserPass = (EditText) formView.findViewById(R.id.edit2);
        formView.post(new Runnable() {
            @Override
            public void run() {
                int delta = formView.getTop() + formView.getHeight();
                formView.setTranslationY(-1 * delta);
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
            InputStream in = getResources().openRawResource(com.example.houshuai.qingdan.R.raw.welcome_video);
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
        switch (inputType) {
            case NONE:

                formView.animate().translationY(0).alpha(1).setDuration(500).start();
                if (view == buttonLeft) {
                    inputType = LOGIN;
                    buttonLeft.setText(com.example.houshuai.qingdan.R.string.button_confirm_login);
                    buttonRight.setText(com.example.houshuai.qingdan.R.string.button_cancel_login);

                } else if (view == buttonRight) {
                    inputType = SIGN_UP;
                    buttonLeft.setText(com.example.houshuai.qingdan.R.string.button_confirm_signup);
                    buttonRight.setText(com.example.houshuai.qingdan.R.string.button_cancel_signup);
                }

                break;
            case LOGIN:

                formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                if (view == buttonLeft) {
                    //denglu
                    String userName = mUserName.getText().toString().trim();
                    String userPass = mUserPass.getText().toString().trim();
                    boolean has = new LoginUtil(application).nameEqualPass(userName, userPass);
                    if (!has) {
                        Toast.makeText(this, "用户不存在,请注册", Toast.LENGTH_LONG).show();
                    } else {
                        toMainActivity();
                    }

                } else if (view == buttonRight) {

                }
                inputType = InputType.NONE;
                buttonLeft.setText(com.example.houshuai.qingdan.R.string.button_login);
                buttonRight.setText(com.example.houshuai.qingdan.R.string.button_signup);
                break;
            case SIGN_UP:
                formView.animate().translationY(-1 * delta).alpha(0).setDuration(500).start();
                if (view == buttonLeft) {
                    // TODO: 2016/7/8 zhuce
                    toMainActivity();
                } else if (view == buttonRight) {

                }
                inputType = InputType.NONE;
                buttonLeft.setText(com.example.houshuai.qingdan.R.string.button_login);
                buttonRight.setText(com.example.houshuai.qingdan.R.string.button_signup);
                break;
        }
    }

    enum InputType {
        NONE, LOGIN, SIGN_UP;
    }
}
