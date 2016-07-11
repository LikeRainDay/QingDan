package com.example.houshuai.qingdan.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.houshuai.qingdan.R;

public class SelfAbout extends AppCompatActivity {

    ImageView aboutBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self_about);
       aboutBack = (ImageView) findViewById(R.id.about_back);
        aboutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
