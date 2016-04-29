package com.napps.acads.ghotdiary.Sem11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;


public class LectureSlides extends Activity {

    int check=0;
    int[] pic={R.drawable.genchem,R.drawable.math11,R.drawable.meow1,R.drawable.eg1,R.drawable.genbio1,R.drawable.trw1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slides);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String[] list = {"General Chemistry ", "Mathematics-I", "MEOW", "Engineering Graphics","General Biology","Tech Report Writing"};
        ListAdapter custom = new CustomList(this, list,pic);
        ListView homelist = (ListView) findViewById(R.id.slidelist);
        homelist.setAdapter(custom);


        homelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                      //  Toast.makeText(LectureSlides.this, "Opening...", Toast.LENGTH_SHORT).show();
                        check = 0;
                        Chem();
                        break;
                    case 1:
                      //  Toast.makeText(LectureSlides.this, "Opening...", Toast.LENGTH_SHORT).show();
                        check = 1;
                        math();
                        break;
                    case 2:
                      //  Toast.makeText(LectureSlides.this, "Opening...", Toast.LENGTH_SHORT).show();
                        check = 2;
                        meow();
                        break;
                    case 3:
                      //  Toast.makeText(LectureSlides.this, "Opening...", Toast.LENGTH_SHORT).show();
                        check = 3;
                        Egraphics();
                        break;
                    case 4:
                        Toast.makeText(LectureSlides.this, "It would be better if you go for the book", Toast.LENGTH_LONG).show();
                        check = 4;
                        genbio();
                        break;
                    case 5:
                       // Toast.makeText(LectureSlides.this, "Under Construction...", Toast.LENGTH_SHORT).show();
                        check = 5;
                        techRep();
                        break;
                    default:
                        Toast.makeText(LectureSlides.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                        check = -1;
                        System.exit(5);

                }

            }
        });
    }

    public void Chem()
    {
        Intent i=new Intent(this,GenChem.class);
        startActivity(i);
    }
    public void math()
    {
        Intent i=new Intent(this,MathOne.class);
        startActivity(i);
    }

    public void meow()
    {
        Intent i=new Intent(this,Meow.class);
        startActivity(i);
    }
    public void Egraphics()
    {
        Intent i=new Intent(this,EGraphics.class);
        startActivity(i);
    }

    public void genbio()
    {
        Intent i=new Intent(this,GenBio.class);
        startActivity(i);
    }
    public void techRep()
    {
        Intent i=new Intent(this,TechRep.class);
        startActivity(i);
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
