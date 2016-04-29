package com.napps.acads.ghotdiary.Extras;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.R;
import com.parse.ParseObject;

import java.util.regex.Pattern;


public class Feedback extends Activity {

    EditText feedback;
    TextView send;
    String data;
    String emailID=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

         feedback=(EditText) findViewById(R.id.feedback);
         send=(TextView) findViewById(R.id.send);


    }

    public void Send(View view)
    {
        AlertDialog dialog = new AlertDialog.Builder(this).create();

        data= feedback.getText().toString();
        if(!data.isEmpty())
        {
            getAccount();


            if (isNetworkAvailable())
            {
                sendData();

                dialog.setTitle("Feedback Sent");
                dialog.setMessage(" Thank you ,we will look into it soon");
                dialog.setCanceledOnTouchOutside(false);

                dialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                feedback.setText("");
                dialog.show();
            }
            else
            {
                dialog.setTitle("Feedback NOT Sent");
                dialog.setMessage("Unable to connect to the Internet");
                dialog.setCanceledOnTouchOutside(false);
                dialog.setButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        }
        else
        {
            Toast.makeText(Feedback.this,"Please enter your feedback",Toast.LENGTH_SHORT).show();
        }
    }

    public void sendData()
    {
        final String msg="Failure";

        try {
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {

                    ParseObject register2 = new ParseObject("Feedback");
                    register2.put("Feedback", data);
                    register2.put("EmailID", emailID);
                    register2.saveInBackground();
                    register2.unpinInBackground();
                    return msg;
                }

            }.execute(null,null,null);
        }
        catch (NullPointerException e)
        {
            Toast.makeText(Feedback.this,"Could Not Send the feedback",Toast.LENGTH_SHORT).show();
        }

    }

    public void getAccount()
    {
        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
        Account[] accounts = manager.getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                String possibleEmail = account.name;

                emailID=emailID+possibleEmail+" , ";
            }
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
