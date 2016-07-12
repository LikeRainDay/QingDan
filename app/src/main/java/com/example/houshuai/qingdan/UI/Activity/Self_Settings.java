package com.example.houshuai.qingdan.UI.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.houshuai.qingdan.App;
import com.example.houshuai.qingdan.Base.BaseActivity;
import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.MoreWindow;
import com.example.houshuai.qingdan.bean.DataCleanManager;
import com.example.houshuai.qingdan.utils.LoginUtil;
import com.example.houshuai.qingdan.utils.ShareUtil;

import java.util.List;

import butterknife.BindView;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by HouShuai on 2016/7/8.
 */

public class Self_Settings extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.self_settings_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.self_GeRen)
    LinearLayout mTself_GeRen;
    @BindView(R.id.self_XiuGaiPass)
    LinearLayout mself_XiuGaiPass;
    @BindView(R.id.self_TongZhi)
    LinearLayout mself_TongZhi;
    @BindView(R.id.self_CleanCaches)
    LinearLayout mself_CleanCaches;
    @BindView(R.id.self_back)
    ImageView selfBack;


    @BindView(R.id.self_GuanYv)
    LinearLayout mself_GuanYv;
    @BindView(R.id.self_ShareApp)
    LinearLayout mself_ShareApp;
    @BindView(R.id.self_YiJianFanKu)
    LinearLayout mself_YiJianFanKu;
    @BindView(R.id.self_settings_button)
    Button mself_settings_button;
    private App application;
    private MoreWindow mMoreWindow;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.self_GeRen:
                //1,定义普通对话框的创建者
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                //设置图片
                builder.setIcon(R.drawable.icon_addfriends);
                //设置标题
                builder.setTitle("个人信息");

                //设置内容
                view = LayoutInflater.from(this).inflate(R.layout.self_info, null);
                builder.setView(view);
                TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
                TextView tv_pass = (TextView) view.findViewById(R.id.tv_pass);
                if (application.mIsLogin) {
                    List<String> mySharePerference = application.getMySharePerference(application.mID);
                    String name = mySharePerference.get(0);
                    String pass = mySharePerference.get(1);
                    tv_name.setText(name);
                    tv_pass.setText(pass);
                }
                //显示对话框
                builder.show();
                Toast.makeText(getApplicationContext(), "点击了个人", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_XiuGaiPass:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setIcon(R.drawable.screat);
                builder2.setTitle("修改密码");
                //布局加载器
                view = LayoutInflater.from(this).inflate(R.layout.changepassword, null);
                //得到布局中的控件
                final EditText et_oldpwd = (EditText) view.findViewById(R.id.et_oldpwd);
                final EditText et_newpwd = (EditText) view.findViewById(R.id.et_newpwd);
                //为对话框设置视图
                builder2.setView(view);
                //取消按钮
                builder2.setNegativeButton("取消", null);
                //确定按钮（输出 姓名和密码）
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String oldpwd = et_oldpwd.getText().toString();
                        if (application.mIsLogin) {
                            List<String> mySharePerference = application.getMySharePerference(application.mID);
                            String pass = mySharePerference.get(1);
                            if (pass.equals(oldpwd)) {
                                mySharePerference.set(1, et_newpwd.getText().toString());
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "请登录", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //显示对话框
                builder2.show();
                Toast.makeText(getApplicationContext(), "点击了修改密码", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_TongZhi:

                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setIcon(R.drawable.icon_creatgread);
                builder3.setTitle("消息通知");

                //布局加载器
                view = LayoutInflater.from(this).inflate(R.layout.notification, null);
                //得到布局中的控件
                final CheckBox cb_cancel = (CheckBox) view.findViewById(R.id.cb_cancel);
                //为对话框设置视图
                builder3.setView(view);
                //取消按钮
                builder3.setNegativeButton("取消", null);
                //确定按钮（输出 姓名和密码）
                builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (cb_cancel.isChecked()) {
                            JPushInterface.stopPush(getApplicationContext());
                        } else {
                            JPushInterface.resumePush(getApplicationContext());
                        }
                    }
                });
                //显示对话框
                builder3.show();
                Toast.makeText(getApplicationContext(), "点击了通知", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_CleanCaches:
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setIcon(R.drawable.search_btn_trash_nor);
                builder4.setTitle("缓存清理");
                //布局加载器
                view = LayoutInflater.from(this).inflate(R.layout.cleancaches, null);
                //得到布局中的控件
                final CheckBox cb_internalcaches = (CheckBox) view.findViewById(R.id.cb_internalcaches);
                final CheckBox cb_alldata = (CheckBox) view.findViewById(R.id.cb_alldata);
                //为对话框设置视图
                builder4.setView(view);
                //取消按钮
                builder4.setNegativeButton("取消", null);
                //确定按钮（输出 姓名和密码）
                builder4.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (cb_internalcaches.isChecked()) {
                            DataCleanManager.cleanApplicationData(getApplicationContext());
                            Toast.makeText(getApplicationContext(), "内部缓存清除成功", Toast.LENGTH_LONG).show();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (cb_alldata.isChecked()) {
                            DataCleanManager.cleanApplicationData(getApplicationContext());
                            Toast.makeText(getApplicationContext(), "数据清理完毕", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                //显示对话框
                builder4.show();
                Toast.makeText(getApplicationContext(), "点击了缓存", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_GuanYv:
                Intent intent1 = new Intent(this, SelfAbout.class);
                startActivity(intent1);
                Toast.makeText(getApplicationContext(), "点击了关于", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_ShareApp:

                String packageName = getPackageName();
//                    String versionName = this.getPackageManager().getPackageInfo(packageName, 0).versionName;
//                    int versionCode = getPackageManager().getPackageInfo(packageName, 0).versionCode;
                Bundle bundle = new Bundle();
                bundle.putString("fulName", "清单");
                bundle.putString("imageurl", "http://www.eqingdan.com/asset/img/wechat-qrcode.jpg");
                bundle.putString("url", "https://www.baidu.com/link?url=C4R1j7UYcGGdQBzrkkQQKbbEg2fVEZul6BMOd0Pmp7_3nGspNqlNXdMVfdgcX7Ph&wd=&eqid=da592ebc0007a95e0000000357849c29");
                bundle.putString("text", "packageName");
                ShareUtil.startAuto(this, bundle);
                break;
            case R.id.self_YiJianFanKu:
                AlertDialog.Builder builder6 = new AlertDialog.Builder(this);
                builder6.setIcon(R.drawable.self_suggetions);
                builder6.setTitle("您的意见：");
                //布局加载器
                view = LayoutInflater.from(this).inflate(R.layout.suggestion, null);
                //得到布局中的控件
                final EditText et_suggetion = (EditText) view.findViewById(R.id.et_oldpwd);
                //为对话框设置视图
                builder6.setView(view);
                //确定按钮（输出 姓名和密码）
                builder6.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        String suggetion = et_suggetion.getText().toString();
                        Toast.makeText(getApplication(), "谢谢您的建议", Toast.LENGTH_LONG).show();
//                        try {
//                            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + File.separator, "suggetions.txt"
//                            );
//                            //第二个参数意义是说是否以append方式添加内容
//                            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
//                            bw.write(suggetion);
//                            bw.flush();
//                            System.out.println("写入成功");
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
                    }
                });
                //显示对话框
                builder6.show();
                Toast.makeText(getApplicationContext(), "点击了意见反馈", Toast.LENGTH_LONG).show();
                break;
            case R.id.self_back:
                finish();
                break;
            case R.id.self_settings_button:
                //退出登录
                application.setIsLoginSharedPreferences(false, application.mID);
                application.checkIsLogin();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("settings", true);
                startActivity(intent);
                finish();
                break;

        }
    }


    @Override
    protected void initLayout() {
        LoginUtil.windowSettings(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        addListener();
        application = (App) getApplication();
    }

    private void addListener() {
        mTself_GeRen.setOnClickListener(this);
        mself_XiuGaiPass.setOnClickListener(this);
        mself_TongZhi.setOnClickListener(this);
        mself_CleanCaches.setOnClickListener(this);
        mself_GuanYv.setOnClickListener(this);
        mself_ShareApp.setOnClickListener(this);
        mself_YiJianFanKu.setOnClickListener(this);
        mself_settings_button.setOnClickListener(this);
        selfBack.setOnClickListener(this);
    }

    @Override
    protected int getActivityID() {
        return R.layout.self_settings;
    }


}
