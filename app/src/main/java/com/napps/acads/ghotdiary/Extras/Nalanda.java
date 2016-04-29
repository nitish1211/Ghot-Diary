package com.napps.acads.ghotdiary.Extras;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.napps.acads.ghotdiary.R;


public class Nalanda extends Activity {

    WebView web;
    String url="http://nalanda.bits-pilani.ac.in/my/";
    ProgressDialog progress ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nalanda);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        progress= new ProgressDialog(Nalanda.this);
        progress.setCancelable(false);


        web=(WebView) findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setAllowFileAccess(true);
        WebView wb = new WebView(this);
        WebSettings ws = web.getSettings();
        ws.setSaveFormData(true);
        ws.setSavePassword(true);
        ws.setBuiltInZoomControls(true);
        ws.setSupportZoom(true);

        web.setWebViewClient(new mwebViewClient());

        web.loadUrl(url);
        web.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

                //download file using web browser
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(web.canGoBack())
        {
            web.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    public class mwebViewClient extends WebViewClient
    {


        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setTitle("Loading...");
            progress.setMessage("Please Wait");
            progress.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progress.dismiss();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
