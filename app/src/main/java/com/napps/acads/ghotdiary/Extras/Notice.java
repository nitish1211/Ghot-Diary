package com.napps.acads.ghotdiary.Extras;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Notice extends Activity {

    String picUrl;
    Bitmap bmp;
    ImageView pic;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        //All the variables to be changed declared here

         pic=(ImageView)findViewById(R.id.pic);
        TextView news=(TextView) findViewById(R.id.news);
        TextView date=(TextView) findViewById(R.id.date);
        TextView venue=(TextView) findViewById(R.id.venue);
        TextView time=(TextView) findViewById(R.id.time);
        TextView contact=(TextView) findViewById(R.id.contact);
        TextView contactName=(TextView) findViewById(R.id.contactName);
        loading=(ProgressBar)findViewById(R.id.loading);

        //Setting all the variables according to the data received
        Bundle notif=getIntent().getExtras();
        news.setText(notif.getString("content"));
        date.setText(notif.getString("date"));
        venue.setText(notif.getString("venue"));
        time.setText(notif.getString("time"));
        contact.setText(notif.getString("number"));
        contactName.setText(notif.getString("contact"));

        //Animating the progressbar
        loading.setVisibility(View.VISIBLE);
        loading.setProgress(40);


        picUrl=notif.getString("picUrl");
        picLoad();

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

    public void picLoad() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg;

                try {
                    URL url = new URL(picUrl);
                    bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                }
                catch (MalformedURLException e)
                {
                    Toast.makeText(Notice.this, "Unable to Load Image..", Toast.LENGTH_LONG).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(Notice.this, "Some I/O Exception..", Toast.LENGTH_LONG).show();
                }

                msg="success";
                return msg;
            }

            @Override
            protected void onPostExecute(String s) {
                //Setting the image wid the bitmap dat we got

                loading.setProgress(100);
                loading.setVisibility(View.GONE);
                pic.setImageBitmap(bmp);

            }
        }.execute(null,null,null);
    }
}
