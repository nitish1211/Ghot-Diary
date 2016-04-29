package com.napps.acads.ghotdiary.Extras;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Patterns;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Nitish on 10/12/2015.
 */
public class GhotDiary extends Application {

    String emailID=" ";
    String PROJECT_NUMBER = "616192671524";
    GoogleCloudMessaging gcm=null;
    String regid="failed registration";
//    MainActivity mainActivity=new MainActivity();

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "akYNyeXR1zyMtlibBpeNPIBDBvLwCnALbGOcWnba", "FC1KNADaZF9HlgiWZMTn3moMgodkpjdfuGeE8j5G");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

//        if(mainActivity.checkPlayServices())
//        {
            getAccount();
            getRegId();
            sendToServer();
//       }

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

    public void sendToServer ()
    {
        final String msg="Failure";
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                ParseObject register = new ParseObject("GhotGCM3");
                register.put("GCMRegID", regid);
                register.put("EmailID", emailID);
                register.saveInBackground();
                return msg;
            }
        }.execute(null,null,null);
    }
    public void getRegId() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String msg;

                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(getApplicationContext());
                    }
                    regid = gcm.register(PROJECT_NUMBER);
                    msg = "Device registered, registration ID=" + regid;
                    Log.i("GCM", msg);

                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();

                }

                return msg;
            }

            @Override
            protected void onPostExecute(String s) {

            }

        }.execute(null,null,null);
    }
}
