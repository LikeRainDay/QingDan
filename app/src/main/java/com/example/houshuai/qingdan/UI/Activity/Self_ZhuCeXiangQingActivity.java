package com.example.houshuai.qingdan.UI.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import me.nereo.multi_image_selector.MultiImageSelector;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by HouShuai on 2016/7/7.
 */

public class Self_ZhuCeXiangQingActivity extends BaseActivity implements View.OnClickListener {
    private final int REQUEST_CODE_GALLERY = 100;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.editText3)
    EditText mName;
    @BindView(R.id.editText7)
    EditText mPass;
    @BindView(R.id.circleImageView2)
    CircleImageView mHeadPic;
    @BindView(R.id.button3)
    Button mButton;
    @BindView(R.id.back)
    ImageView mBack;
    private boolean sucessful;
    private List<String> path = new ArrayList<>();

    @Override
    protected void initLayout() {
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        initWeigt();
    }

    ArrayList<String> mlist = new ArrayList<>();


    @Override

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.circleImageView2:
                //点击小圆跳转
                MultiImageSelector.create(this)
                        .showCamera(true)
                        .count(1)
                        .single()
                        .origin(mlist)
                        .start(this, REQUEST_CODE_GALLERY);

                break;
            case R.id.button3:
                //点击按钮注册
                String name = mName.getText().toString().trim();
                String pass = mPass.getText().toString().trim();
                isSucessful(name, pass);
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("self", true);
                startActivity(intent);
                break;
            case R.id.back:
                //点击返回
                finish();
                break;
        }
    }

    private void isSucessful(String name, String pass) {
        // TODO: 2016/7/7 正则
        String pathString ;
        if (0 == path.size()) {
            pathString = "false";
        } else {
            pathString = path.get(0);
        }
        ((App) getApplication()).setMySharePerference(name, name, pass, pathString, "", "");
        ((App) getApplication()).setIsLoginSharedPreferences(true, name);
    }

    private void initWeigt() {
        mHeadPic.setOnClickListener(this);
        mButton.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    @Override
    protected int getActivityID() {
        return R.layout.self_zhuce_xiangqing;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_GALLERY) {
            if (resultCode == RESULT_OK) {
                path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                // TODO: 2016/7/7 图片采样或者picassio
                mHeadPic.setImageURI(Uri.fromFile(new File(path.get(0))));
            }
        }
    }

}
