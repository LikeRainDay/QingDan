package com.example.houshuai.qingdan.UI.Activity;

import android.content.Context;
import android.content.Intent;
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

import butterknife.BindView;
import cn.smssdk.EventHandler;
import cn.smssdk.OnSendMessageHandler;
import cn.smssdk.SMSSDK;

import static com.example.houshuai.qingdan.R.id.textView4;

/**
 *
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
        initSMSResultHandler();
        addListener();
    }

    @Override
    protected int getActivityID() {
        return R.layout.self_zhuce_pop;
    }

    @Override
    public void onClick(View view) {
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
                //获取验证码
                getMsgNumber();
                break;
            case R.id.button4:
                //下一步
                YanZhengMsg();
                break;
            case R.id.textView6:
                //用户手册
                Toast.makeText(this, "点击了用户手册", Toast.LENGTH_SHORT).show();
                //暂时跳转
                Intent intent = new Intent(Self_ZhuCeActivity.this, Self_ZhuCeXiangQingActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void YanZhengMsg() {
        SMSSDK.submitVerificationCode(mQvHao.getText().toString().trim(), mEditText_phone.getText().toString().trim(), mEditText_msg.getText().toString().trim());
    }

    private void getMsgNumber() {
        SMSSDK.getVerificationCode(mQvHao.getText().toString().trim(), mEditText_phone.getText().toString().trim(), new OnSendMessageHandler() {
            @Override
            public boolean onSendMessage(String s, String s1) {
                Log.d("aaa", s + "<onSendMessage>" + s1);
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
