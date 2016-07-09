package com.example.houshuai.qingdan.UI.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.utils.LoginUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import static com.example.houshuai.qingdan.R.id.textView4;

/**
 * 短信验证界面
 * Created by HouShuai on 2016/7/7.
 */

public class Self_ZhuCeActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.self_callback)
    ImageView mbackImage;
    @BindView(textView4)
    TextView mQvHao;
    @BindView(R.id.editText)
    EditText mEditText_phone;
    @BindView(R.id.editText2)
    EditText mEditText_msg;
    @BindView(R.id.button2)
    Button mYanZheng;
    @BindView(R.id.button4)
    Button mDenglu;
    @BindView(R.id.textView6)
    TextView mYongHuShouCe;


    @Override
    protected void initLayout() {
        LoginUtil.windowSettings(this);

        initSMSResultHandler();
        addListener();
    }

    @Override
    protected int getActivityID() {
        return R.layout.self_zhuce_pop;
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.self_callback:
                //返回    并关闭虚拟键盘
                InputMethodManager systemService = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (systemService != null) {
                    systemService.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                }
                finish();
                break;
            case R.id.button2:
                Pattern compile = Pattern.compile("^((\\(d{3}\\))|(\\d{3}\\-))?13[0-9]\\d{8}|15[89]\\d{8}|18[0-9]\\d{8}");
                Matcher matcher = compile.matcher(mEditText_phone.getText().toString().trim());
                if (matcher.find()) {
                    //获取验证码
                    getMsgNumber();
                } else {
                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button4:
                //下一步
                YanZhengMsg();
                finish();
                break;
            case textView4:
                intent = new Intent(Self_ZhuCeActivity.this, CountryActivity.class);
                startActivityForResult(intent, 13);
                break;
            case R.id.textView6:
                //用户手册
                Toast.makeText(this, "点击了用户手册", Toast.LENGTH_SHORT).show();
                //暂时跳转
                intent = new Intent(Self_ZhuCeActivity.this, Self_ZhuCeXiangQingActivity.class);
                startActivity(intent);
                finish();
                break;

        }

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

    private void YanZhengMsg() {
        SMSSDK.submitVerificationCode(mQvHao.getText().toString().trim().substring(1), mEditText_phone.getText().toString().trim(), mEditText_msg.getText().toString().trim());
    }

    private void getMsgNumber() {
        TimeCount time = new TimeCount(60000, 1000);
        time.start();//开始计时
        SMSSDK.getVerificationCode(mQvHao.getText().toString().trim().substring(1), mEditText_phone.getText().toString().trim(), new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String s, String s1) {
                Log.e("des", s + "----" + s1);
                return false;
            }
        });
    }

    private void initSMSResultHandler() {
        SMSSDK.initSDK(this, "14aa400a62d7e", "34f69a9a008dc933302a2b982b5c207e", false);
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
                        Intent intent = new Intent(Self_ZhuCeActivity.this, Self_ZhuCeXiangQingActivity.class);
                        startActivity(intent);
                    } else {
                        Log.d("aaa", event + "<afterEvent>" + result + ",校验失败");
                    }
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 13:
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

    private void addListener() {
        mbackImage.setOnClickListener(this);
        mQvHao.setOnClickListener(this);
        mEditText_phone.setOnClickListener(this);
        mEditText_msg.setOnClickListener(this);
        mYanZheng.setOnClickListener(this);
        mDenglu.setOnClickListener(this);
        mYongHuShouCe.setOnClickListener(this);
    }

}
