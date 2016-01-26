package com.example.gaby.tvt;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by gaby on 1/12/16.
 */
public class Browser extends Activity {

    WebView browser;
    String activity ="";
    int id;
    String url ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        ActionBar actionBar = getActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        activity += getIntent().getStringExtra("Activity");
        if(!activity.equals(""))
            actionBar.setTitle(activity);
        id += getIntent().getIntExtra("ActivityID",0);
        browser = (WebView) findViewById(R.id.webview);
        browser.setVisibility(View.VISIBLE);
        WebSettings webSettings = browser.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUserAgentString("Desktop");

        browser.setWebViewClient(new WebViewClient());

        url += getIntent().getStringExtra("URL");
        if(url.equals(""))
            Log.w("URL","no url passed");
          // /  url = "https://my.tarbut.com";
        browser.loadUrl(url);
        Log.w("Activity","Activity:" + activity + "\nid: " + id + "\nURl:" + url);
        while(browser.canGoForward()){
            browser.goForward();
        }
        while(browser.canGoBack()){
            browser.goBack();
        }

    }

    @Override
    public void onBackPressed() {
        if(browser.canGoBack()) {
            browser.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
        menu.setGroupVisible(R.id.oldTVT,false);
        menu.setGroupVisible(R.id.settings,false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }


}
