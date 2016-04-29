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


public class Meow extends Activity {

    int check=-99;
    int pic[]={R.drawable.meow1,R.drawable.meow2,R.drawable.meow3,R.drawable.meow4,R.drawable.meow5,R.drawable.meow6,R.drawable.meow7,R.drawable.meow8,R.drawable.meow9,R.drawable.meow10,R.drawable.meow11,R.drawable.meow12};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String list[]={"Review of Newton’s Equations","Linear Momentum","Work, Energy & Power","Angular Momentum (Part-1)","Angular Momentum (Part-2)","Non-inertial systems (Part-1)","Non-inertial systems (Part-2)","Oscillation & Waves","Forced/Driven Oscillations","Coupled Oscillators","Normal Modes of Continuous System","Progressive Waves"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check=position;
                if(!isNetworkAvailable())
                {
                    Toast.makeText(Meow.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Disp();
                }
            }
        });
    }
    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 3);
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

