package com.napps.acads.ghotdiary.Sem11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;


public class ProfDetails extends Activity {

    String email[]={"uma@pilani.bits-pilani.ac.in","shiba@pilani.bits-pilani.ac.in","dasgupta@pilani.bits-pilani.ac.in","s.bhattacharya@pilani.bits-pilani.ac.in","asah@pilani.bits-pilani.ac.in","rajeev.sakhuja@bits-pilani.ac.in","dkumar@pilani.bits-pilani.ac.in","girish_kant@bits-pilani.ac.in","madhukar@pilani.bits-pilani.ac.in","kusum@bits-pilani.ac.in"};

    String name[] = {"Dr. Uma S. Dubey", "Shibasish Chowdhury", "MS Dasgupta", "Somdatta Bhattacharya", "Dr. Ajay Kumar Sah", "Dr. Rajeev Sakhuja", "Devendra Kumar","Girish Kant","Madhukar Mishra","Kusum Lata"};

        String contact[]={"Tel : 91-1596-515633\n" + "Mobile : 9414983494 ","Off : + 91-1596-515642","Off : 01596-244089 \n"+"Off2 : 01596-245073  ","Off : 01596-515819","Unavailable Unfortunately....","Mob : 9950630310","Off : +91-1596-51-5689","Off : +91-1596-245073","Off : +911596-515680"," Off : +91-1596-245073"};

    int profnum;
    String emailID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_details);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle profemail=getIntent().getExtras();

         emailID=email[profemail.getInt("profnum")];
         profnum=profemail.getInt("profnum");


        TextView profName=(TextView) findViewById(R.id.profName);
        TextView profEmail=(TextView) findViewById(R.id.profEmail);
        TextView profContact=(TextView) findViewById(R.id.profContact);


       //Setting up the details of the page
        profName.setText(name[profnum]);
        profEmail.setText("Email  \n\n"+email[profnum]+"                                                                                                                         ");
        profContact.setText("Conatct No. \n\n"+contact[profnum]+"                                                                                                                                                 ");


    }

    public void sendmail(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("plain/text");
        i.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{emailID});
        i.putExtra(Intent.EXTRA_SUBJECT, "");
        i.putExtra(Intent.EXTRA_TEXT, "");
        try {
            startActivity(Intent.createChooser(i, "Send mail...(Preferably GMail) ;)"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(ProfDetails.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
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
