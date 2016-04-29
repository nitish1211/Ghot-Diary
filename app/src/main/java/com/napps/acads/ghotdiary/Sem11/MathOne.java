package com.napps.acads.ghotdiary.Sem11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;


public class MathOne extends Activity {

    int check=-99;
    int []pic={R.drawable.math11,R.drawable.math12,R.drawable.math13,R.drawable.math14,R.drawable.math15,R.drawable.math16,R.drawable.math17};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String list[]={"Chapter 10","Chapter 11","Chapter 13","Chapter 14.1-14.4","Chapter 14.5-14.8","Chapter 15","Chapter 16"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check=position;
                if(!isNetworkAvailable())
                {
                    Toast.makeText(MathOne.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Disp();
                }
            }
        });
    }

    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 2);
        lecture.putExtra("SlideNum", check + 1);
        startActivity(lecture);
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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

