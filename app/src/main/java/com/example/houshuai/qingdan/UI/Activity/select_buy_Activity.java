package com.example.houshuai.qingdan.UI.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.houshuai.qingdan.R;

public class select_buy_Activity extends AppCompatActivity {

    private WebView wv_buy_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_buy_);
        String buylink = getIntent().getStringExtra("buylink");
        wv_buy_id = (WebView) this.findViewById(R.id.wv_buy_id);

        WebSettings settings = wv_buy_id.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();// 将浏览器嵌入到WebView控件中
        wv_buy_id.setWebViewClient(client);

        wv_buy_id.loadUrl(buylink);//加载
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_buy_id.canGoBack()) {

            wv_buy_id.goBack(); // goBack()表示返回WebView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
