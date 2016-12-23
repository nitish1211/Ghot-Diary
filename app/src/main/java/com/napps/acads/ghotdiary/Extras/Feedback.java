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
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.napps.acads.ghotdiary.BGMail.GMailSender;
import com.napps.acads.ghotdiary.R;


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
            //getAccount();


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

                    try {
                        GMailSender gMailSender = new GMailSender(getString(R.string.sender_email), getString(R.string.sender_password));
                        Log.d("email", getString(R.string.admin_email));
                        gMailSender.sendMail("GhotDiary Feedback", "Feedback :"+data, "no-reply@gmail.com", getString(R.string.admin_email));
                    }
                    catch (Exception e)
                    {
                        Log.e("SendMail", e.getMessage(), e);
                    }
                    return msg;
                }

            }.execute(null,null,null);
        }
        catch (NullPointerException e)
        {
            Toast.makeText(Feedback.this,"Could Not Send the feedback",Toast.LENGTH_SHORT).show();
        }

    }

//    public String getAccount()
//    {
//        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
//        String possibleEmail="no-reply@gmail.com";
//        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
//        Account[] accounts = manager.getAccounts();
//        for (Account account : accounts) {
//            if (emailPattern.matcher(account.name).matches()) {
//                 possibleEmail = account.name;
//
//                emailID=emailID+possibleEmail+" , ";
//            }
//        }
//        return possibleEmail;
//    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
