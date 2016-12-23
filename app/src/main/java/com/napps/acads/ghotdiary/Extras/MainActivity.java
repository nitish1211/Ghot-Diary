package com.napps.acads.ghotdiary.Extras;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;
import com.napps.acads.ghotdiary.Sem11.DisplaySlides;
import com.napps.acads.ghotdiary.Sem11.HandoutOne;
import com.napps.acads.ghotdiary.Sem11.LectureSlides;
import com.napps.acads.ghotdiary.Sem11.QPapers11;


public class MainActivity extends Activity {

    int check = 0;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 695576868;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String item[] = {"Nalanda", "Lecture Slides", "Handouts", "TimeTable Booklet",
                "Previous Year Q.Papers", "Other Docs","Feedback"};
        ListAdapter custom = new CustomAdapter(this, item);

        ListView homelist = (ListView) findViewById(R.id.homelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                startNalanda();
                                break;
                            case 1:
                                StartLecture();
                                Toast.makeText(MainActivity.this, "Lecture slides from year 2014", Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                StartHandout();
                                Toast.makeText(MainActivity.this, "Handouts from year 2015", Toast.LENGTH_SHORT).show();
                                break;
                            case 3:
                                startTT();
                                break;
                            case 4:
//                                Toast.makeText(MainActivity.this, "Will be organized and put up soon", Toast.LENGTH_SHORT).show();
                                startQp();
                                break;
                            case 5:
                                startDocs();
                                break;

                            case 6:
                                startFeedback();
                                break;
                            default:
                                Toast.makeText(MainActivity.this, "Something wrong happened ... Shutting Down!!!", Toast.LENGTH_SHORT).show();
                                System.exit(4000);
                        }
                    }
                });
    }


    public void startNalanda()
    {
        Intent nalamda=new Intent(this,Nalanda.class);
        startActivity(nalamda);
    }

    public void StartLecture() {
        Intent lecture = new Intent(this, LectureSlides.class);
        startActivity(lecture);
    }

    public void StartHandout() {
        Intent h = new Intent(this, HandoutOne.class);
        startActivity(h);
    }

    public void startDocs() {
        Intent d = new Intent(this, OtherDocs.class);
        startActivity(d);
    }

    public void startTT() {
        Intent tt = new Intent(this, DisplaySlides.class);
        tt.putExtra("Course", 68);
        tt.putExtra("SlideNum", check + 1);
        if (!isNetworkAvailable()) {
            Toast.makeText(MainActivity.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(tt);
        }
    }

    public void startQp() {
        Intent d = new Intent(this, QPapers11.class);
        startActivity(d);
    }


    public void startFeedback()
    {
        Intent f=new Intent(this,Feedback.class);
        startActivity(f);
    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


}