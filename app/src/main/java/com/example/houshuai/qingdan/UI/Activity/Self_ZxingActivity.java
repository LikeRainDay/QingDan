package com.example.houshuai.qingdan.UI.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.houshuai.qingdan.R;
import com.example.houshuai.qingdan.UI.Custom.EncodingHandler;

import butterknife.BindView;

public class Self_ZxingActivity extends AppCompatActivity {

    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self__zxing_activity);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        iv = (ImageView) findViewById(R.id.iv);
        try {
            //生成二维码图片，第一个参数是二维码的内容，第二个参数是正方形图片的边长，单位是像素
            Bitmap qrcodeBitmap = EncodingHandler.createQRCode(content, 400,400);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.lanch_icon);
            Bitmap qrcodeBitmapLogo = EncodingHandler.add(qrcodeBitmap, bitmap);
            iv.setImageBitmap(qrcodeBitmapLogo);
            iv.setBackgroundResource(R.drawable.background_erweima);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public void click(View view) {
        finish();
    }
}
