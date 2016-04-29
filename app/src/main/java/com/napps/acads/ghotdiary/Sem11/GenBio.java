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


public class GenBio extends Activity {
    int check=-99;
    int[] pic={R.drawable.genbio1,R.drawable.genbio2,R.drawable.genbio3,R.drawable.genbio4,R.drawable.genbio5,R.drawable.genbio6,R.drawable.genbio7,R.drawable.genbio8,R.drawable.genbio9,R.drawable.genbio10,R.drawable.genbio11,R.drawable.genbio12,R.drawable.genbio13,R.drawable.genbio14,R.drawable.genbio15,R.drawable.genbio16,R.drawable.genbio17};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String list[]={"Lecture-1","Lecture-2","Lecture-3","Lecture-4","Lecture-5","Lecture-6","Lecture-7","Lecture-8","Lecture-9","Lecture-10","Lecture-11","Lecture-12","Lecture-13","Lecture-14","Lecture-15","Lecture-16","Lecture-17"};

        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check = position;
                if(!isNetworkAvailable())
                {
                    Toast.makeText(GenBio.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Disp();
                }
            }
        });
    }
    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 5);
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

