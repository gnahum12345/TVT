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
        if(id != 0){
            menu.findItem(id).setVisible(false);
        }
        menu.findItem(R.id.zeroPeriod).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch(id){
            case android.R.id.home:
                finish();
                return true;
            case R.id.maps:
                //TODO go to maps activity and direct from current location to 5 federation way
                intent = new Intent(Browser.this, Browser.class);
                Log.w("Activity", "is about to change to the same activity");
                intent.putExtra("URL","the url");
                intent.putExtra("Activity","Maps");
                intent.putExtra("ActivityID",R.id.maps);
                startActivity(intent);
                Log.w("Activity","Just changed");
                return true;
            case R.id.action_settings:
                //TODO go to the settings activity
                intent = new Intent(Browser.this,Settings.class);
                startActivity(intent);
                return true;
            case R.id.blood:
                //TODO go to activity with the blood drive consent form
                return true;
            case R.id.asbCal:
                //TODO go to activity with calendar that shows everything tab for ASB AND For MASTER CAL
                return true;
            case R.id.masterCal:
                //TODO go to the same activity as asbCal
                return true;
            case R.id.studentCouncil:
                //TODO go to the same activity as asbCal has a tab for MS
                return true;
            case R.id.USletterRot:
                //TODO go to an activity with the letter rotation.
                return true;
            case R.id.MSletterRot:
                //TODO go to an activity with the letter rotation. same as US but has a tab for MS
                return true;
            case R.id.schedule:
                //TODO go to an activity with the schedule.
                return true;
            case R.id.handbook:
                //TODO go to an activity with the schedule and handbook.
                break;
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
