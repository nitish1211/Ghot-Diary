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


public class EGraphics extends Activity {

    int check=-99;
    int pic[]={R.drawable.eg1,R.drawable.eg2,R.drawable.eg3,R.drawable.eg4,R.drawable.eg5,R.drawable.eg6,R.drawable.eg7,R.drawable.eg8,R.drawable.eg9,R.drawable.eg10,R.drawable.eg11,R.drawable.eg12,R.drawable.eg13};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String list[]={"EG Intro-1","EG Intro-2","Orthographic Projections-1","Orthographic Projections-2","Isometric-1","Isometric-2","Projection of Line","Projection of Plane","Projection of Solids-1","Projection of Solids-2","Section of Solids","Development of Surface","Intersection of Surface"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);



        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                check = position;
                if(!isNetworkAvailable())
                {
                    Toast.makeText(EGraphics.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                }
                else {
                    Disp();
                }
            }
        });
    }

    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 4);
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

