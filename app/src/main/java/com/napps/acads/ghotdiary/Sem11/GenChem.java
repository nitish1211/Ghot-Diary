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


public class GenChem extends Activity {

    int check=-99;
    int pic[]={R.drawable.genchem,R.drawable.genchem2,R.drawable.genchem3,R.drawable.genchem4,R.drawable.genchem5,R.drawable.genchem6,R.drawable.genchem7,R.drawable.genchem8,R.drawable.genchem9,R.drawable.genchem10,R.drawable.genchem21,R.drawable.genchem22,R.drawable.genchem23,R.drawable.genchem24,R.drawable.genchem25,R.drawable.genchem26,R.drawable.genchem27,R.drawable.genchem28,R.drawable.genchem29,R.drawable.genchem30,R.drawable.genchem31,R.drawable.genchem32,R.drawable.genchem33,R.drawable.genchem34,R.drawable.genchem35,R.drawable.genchem36,R.drawable.genchem37,R.drawable.genchem38,R.drawable.genchem39,R.drawable.genchem40,R.drawable.genchem41,R.drawable.genchem42,R.drawable.genchem43,R.drawable.genchem44,R.drawable.genchem45,R.drawable.genchem45,R.drawable.genchem46,R.drawable.genchem47,R.drawable.genchem48,R.drawable.genchem49};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String[] list = {"Lecture-01","Lecture-02","Lecture-03","Lecture-04","Lecture-05","Lecture-06","Lecture-07","Lecture-08","Lecture-09","Lecture-10","Lecture-11","Lecture-12","Lecture-13","Lecture-14","Lecture-15","Lecture-16","Lecture-17","Lecture-18","Lecture-19","Lecture-20","Lecture-21","Lecture-22","Lecture-23","Lecture-24","Lecture-25","Lecture-26","Lecture-27","Lecture-28","Lecture-29","Lecture-30","Lecture-31","Lecture-32","Lecture-33","Lecture-34","Lecture-35","Lecture-36","Lecture-37","Lecture-38","Lecture-39"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check = position;
                if(!isNetworkAvailable())
                {
                    Toast.makeText(GenChem.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Disp();
                }
            }
        });
    }

    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 1);
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
