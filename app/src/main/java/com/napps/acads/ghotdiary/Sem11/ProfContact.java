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


public class ProfContact extends Activity {

    int profNo=-99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        String name[] = {"Dr. Uma S. Dubey", "Shibasish Chowdhury", "MS Dasgupta", "Somdatta Bhattacharya", "Dr. Ajay Kumar Sah", "Dr. Rajeev Sakhuja", "Devendra Kumar","Girish Kant","Madhukar Mishra","Kusum Lata"};
        String courseCode[] = {"Bio Lab BIO(F110)", "General Biology BIO(F110)", "Engineering Graphics BITS(F110)", "Tech Report Writing BITS(F112)", "Chemistry Laboratory CHEM(F110)", "General Chemistry CHEM(F111)", "Mathematics-I MATH(F111)","Workshop ME(F110)","Physics Laboratory PHY(F110)","Mech Osc & Waves PHY(F111)"};
        ListAdapter custom = new ProfAdapter(this, name,courseCode);
        ListView profList=(ListView) findViewById(R.id.profList);
        profList.setAdapter(custom);


        profList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                        profNo=0;
                        profdetails(profNo);
                        break;
                    case 1:
                        profNo=1;
                        profdetails(profNo);
                        break;
                    case 2:
                        profNo=2;
                        profdetails(profNo);
                        break;
                    case 3:
                        profNo=3;
                        profdetails(profNo);
                        break;
                    case 4:
                        profNo=4;
                        profdetails(profNo);
                        break;
                    case 5:
                        profNo=5;
                        profdetails(profNo);
                        break;
                    case 6:
                        profNo=6;
                        profdetails(profNo);
                        break;
                    case 7:
                        profNo=7;
                        profdetails(profNo);
                        break;
                    case 8:
                        profNo=8;
                        profdetails(profNo);
                        break;
                    case 9:
                        profNo=9;
                        profdetails(profNo);
                        break;
                   default:
                       Toast.makeText(ProfContact.this, "Something wrong happened", Toast.LENGTH_SHORT).show();
                       System.exit(1000);

                }
            }
        });
    }

    public void profdetails(int profnum)
    {
        Intent prof=new Intent(this,ProfDetails.class);
        prof.putExtra("profnum",profnum);
        startActivity(prof);
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
