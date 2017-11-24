package com.example.adam.myapplication;

//package com.example.jerry.myapp2;
/**
 * The reference
 *  https://jerrynest.io/app-android-webview/
 *https://stackoverflow.com/questions/16152491/enable-back-button-in-webview
 *https://stackoverflow.com/questions/6077141/how-to-go-back-to-previous-page-if-back-button-is-pressed-in-webview
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setContentView(webview);
//        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webview.loadUrl("http://www.what-the-feed.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


}