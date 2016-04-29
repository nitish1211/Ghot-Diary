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


public class QPapers11 extends Activity {
    int pic[]={R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1,R.drawable.pdf1};
    int check=-99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String[] list = {"General Chemistry ", "Mathematics-I", "MEOW", "Engineering Graphics","General Biology","Tech Report Writing","Workshop"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        check = 0;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 1:
                        check = 1;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 2:
                        check = 2;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 3:
                        check = 3;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 4:
                        check = 4;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 5:
                        check = 5;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    case 6:
                        check= 6;
                        if(!isNetworkAvailable())
                        {
                            Toast.makeText(QPapers11.this, "Please Connect to the internet", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Disp();
                        }
                        break;
                    default:
                        Toast.makeText(QPapers11.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                        check = -1;
                        System.exit(5);

                }

            }
        });
    }


    public void Disp() {
        Intent lecture = new Intent(this, DisplaySlides.class);
        lecture.putExtra("Course", 67);
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
