package com.napps.acads.ghotdiary.Sem11;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;

import com.napps.acads.ghotdiary.R;


public class DisplaySlides extends Activity {

    String downloadUrl="lol";
    String name="lol";
    String urlFinal="www.google.com";
    ProgressDialog progress ;
   boolean check=true;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dispay_slides);

        WebView web=(WebView)findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
      //  web.getSettings().setPluginsEnabled(true);
        web.getSettings().setAllowFileAccess(true);
        web.getSettings().setSupportZoom(true);
        web.getSettings().setBuiltInZoomControls(true);


        Bundle slide=getIntent().getExtras();
        if(slide==null)
        {
            return;
        }
        int slidenum=slide.getInt("SlideNum");
        int course=slide.getInt("Course");

        progress= new ProgressDialog(DisplaySlides.this);
        progress.setMax(6);

        web.setWebViewClient(new mwebViewClient());


        switch(course)
        {
            case 1:
                web.loadUrl(genChem(slidenum));
                urlFinal=genChem(slidenum);
                getDownloadUrl(genChem(slidenum));
                name="GenChem lecture "+slidenum;
                break;
            case 2:
                web.loadUrl(Math1(slidenum));
                urlFinal=Math1(slidenum);
                getDownloadUrl(Math1(slidenum));
                name="Mathematics-I lecture "+slidenum;
                break;
            case 3:
                web.loadUrl(Meow(slidenum));
                urlFinal=Meow(slidenum);
                getDownloadUrl(Meow(slidenum));
                name="MEOW lecture "+slidenum;
                break;
            case 4:
                web.loadUrl(Eg(slidenum));
                urlFinal=Eg(slidenum);
                getDownloadUrl(Eg(slidenum));
                name="Eg lecture "+slidenum;
                break;
            case 5:
                web.loadUrl(genBio(slidenum));
                urlFinal=genBio(slidenum);
                getDownloadUrl(genBio(slidenum));
                name="GenBio lecture "+slidenum;
                break;
            case 6:
                web.loadUrl(techrep(slidenum));
                urlFinal=techrep(slidenum);
                getDownloadUrl(techrep(slidenum));
                name="Techrep lecture "+slidenum;
                break;
            case 7:
                web.loadUrl(otherDocs(slidenum));
                urlFinal=otherDocs(slidenum);
                getDownloadUrl(otherDocs(slidenum));
                name=otherName(slidenum);
                break;
            case 69:
                web.loadUrl(handout(slidenum));
                urlFinal=handout(slidenum);
                getDownloadUrl(handout(slidenum));
                name="Handout";
                break;
            case 68:
                web.loadUrl(timetable());
                urlFinal=timetable();
                getDownloadUrl(timetable());
                name="Timetable Booklet";
                break;
            case 67:
                web.loadUrl(qpapers(slidenum));
                urlFinal=qpapers(slidenum);
                getDownloadUrl(qpapers(slidenum));
                name=qpaperName(slidenum);
                break;
            default:
                web.loadUrl("www.google.com");
                urlFinal="www.google.com";
                setContentView(web);
        }
    }

    public String genChem(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSXVrVVlvUUlkaVU");
                break;
            case 2:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBNEJzRXVYQUI3aDg");
                break;
            case 3:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBUFJnNEFRQlgtb2s");
                break;
            case 4:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBbUZkc1l3TU5GejQ");
                break;
            case 5:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBOGdZVkZaSDlZdG8");
                break;
            case 6:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBc1VaMlA1b2o3bEU");
                break;
            case 7:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBQ3J1NVRkVlVEaXc");
                break;
            case 8:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBclBpVVRORXI0RFk");
                break;
            case 9:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBZGwyZ2ZSUS0wR1E");
                break;
            case 10:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBNHloaFhSUFZ4YXc");
                break;
            case 11:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBbzBvd2NyYXNKSEE");
                break;
            case 12:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBeEVSdDFmbzd1VnM");
                break;
            case 13:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSTZqY0hpWFhMeE0");
                break;
            case 14:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBVm5jbFRIMkdNQXc");
                break;
            case 15:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBY0hCMHhfbnRMRjg");
                break;
            case 16:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBeTBWM3JPY2RmbWM");
                break;
            case 17:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBdE8ySDZhOFhaQTQ");
                break;
            case 18:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBY2QyTVgtN1J4Qzg");
                break;
            case 19:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBX3dlMmgtVjlwVDA");
                break;
            case 20:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBUlFMU2UtdURWQW8");
                break;
            case 21:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSnUzSWpaQXNxUXM");
                break;
            case 22:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBVGRYWEtjLWxHN3c");
                break;
            case 23:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBM3dvMDVoWlNqZjQ");
                break;
            case 24:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBaEkySDkxWG5iQW8");
                break;
            case 25:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBWEZFS2syYUY2SU0");
                break;
            case 26:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSmVxZ2YzMDJxdVk");
                break;
            case 27:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBbGxudk9qaFRsMzA");
                break;
            case 28:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSzNacWcyU2FKZTg");
                break;
            case 29:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBMEZvUWRTTjFmcVE");
                break;
            case 30:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBdF9BanlIUWJmTlU");
                break;
            case 31:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBZDZObmZLVHNsUVE");
                break;
            case 32:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBcUthSFVzaDhhYUE");
                break;
            case 33:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSlU5SENzNDdOVDg");
                break;
            case 34:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSE1JT2djOS1ubUU");
                break;
            case 35:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBalVSNzhfX3hPTTg");
                break;
            case 36:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBVnhFWGhEYWQyckk");
                break;
            case 37:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBcGpnSE1xMjlOX1U");
                break;
            case 38:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBRm9rTWJ3WTBOM2s");
                break;
            case 39:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBclQ3LUgyaXhvb3c");
                break;
            default:

                url="www.google.com";
        }
        return url;
    }

    public String Meow(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBMDNlbWhZbndfcmc");
                break;
            case 2:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBc0pYRHo4ZHktb2c");
                break;
            case 3:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBOG5NYnh2Nms4Tjg");
                break;
            case 4:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBVlBUUE9za3NFU0E");
                break;
            case 5:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBR2tpcjB4aFRjNGM");
                break;
            case 6:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBMnJ4V3dsbTV6dnc");
                break;
            case 7:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBejNCZVQzT09TOFU");
                break;
            case 8:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBX2xod2VkdnFCb0U");
                break;
            case 9:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBSl9zbnVCR0pUYU0");
                break;
            case 10:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBVXoySlYzMnRBUVE");
                break;
            case 11:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBeksyTkFqVmkwdnc");
                break;
            case 12:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBOFR0ellxbk92cHc");
                break;
            default:
                url=("www.google.com");
                break;
        }
        return url;
    }

    public String Math1(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBdjBoWnJLWHpSSFk");
                break;
            case 2:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBX3AxdF8ycXZYQUU");
                break;
            case 3:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBNFBtSzNhZXpETUU");
                break;
            case 4:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBY29qaVFldkYtQ3M");
                break;
            case 5:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBUml4WTJWUWp4ZFE");
                break;
            case 6:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBUDczRVp4OWg4S0k");
                break;
            case 7:
                url=("https://drive.google.com/open?id=0B6g3rUcjc3hBd0ZDQ3ozb0xxNEU");
                break;
            default:
                url=("www.google.com");
        }
        return url;
    }


    public String handout(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBODF3UDNER3hDVGc";
                break;
            case 2:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBZU5XWnFOeXV6S1E";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBYXBScVNONW8yb0E";
                break;
            case 4:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBejJkY1E5dXlmbDQ";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBcUNXdjlIVlg2emc";
                break;
            case 6:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBaXp4YWhxN1hXVXM";
                break;
            case 7:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBSUhFbWloTHA4ckU";
                break;
            case 8:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBbnBhUkdPdTZieWM";
                break;
            case 9:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBQ01CMHMwQUlUNHc";
                break;
            case 10:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBOGduMHlmS2kzUHc";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }

    public String Eg(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMXFQSmVBUkhBNHM";
                break;
            case 2:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBNlhLWnVtZlZTczg";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBUWM2MExXMkRvdWM";
                break;
            case 4:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBcEJXdW5sal9oN1k";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBSlFLRThDdWVRdnM";
                break;
            case 6:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBZDk2SDEzODh0MXM";
                break;
            case 7:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBN3ZIdUYxZ0VNbWM";
                break;
            case 8:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBTjh3VVBBWnZsTms";
                break;
            case 9:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMVZQX1BWMENqckE";
                break;
            case 10:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBSjJaXzNJTVRRYU0";
                break;
            case 11:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBWVJWUzRTcjB3QnM";
                break;
            case 12:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBdjY1Q0xhUl8yTDQ";
                break;
            case 13:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBR2pxdU1JbzRZQ2M";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }

    public String genBio(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBWF9MZlJLMUQ4dUU";
                break;
            case 2:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBNEs3UDl2RTNjTHc";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBUWNyXzRmT3ZJSzg";
                break;
            case 4:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBemFjM29ieVUzbUU";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBYTk0YzhJbl9SUkk";
                break;
            case 6:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBb0hJckNTcFg5RUU";
                break;
            case 7:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMUVZakRoX1VnbFU";
                break;
            case 8:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBalRITW5nM291ZDg";
                break;
            case 9:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBU1B5M3R4WTJlZFE";
                break;
            case 10:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBWERLSmpKV1R5TDg";
                break;
            case 11:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBbEpPbUNsakZuY1k";
                break;
            case 12:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBQnNPOU1MTkM1Rjg";
                break;
            case 13:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBT1c0TV9QTkR1d1U";
                break;
            case 14:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBX0Q3T3ptRUl2WGc";
                break;
            case 15:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBempRSjFPTVVpQ1U";
                break;
            case 16:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMXhlcGt0YnFUUzA";
                break;
            case 17:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMXRSd1d3eTF2LUk";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }

    public String techrep(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBTHAwTnNpZzFoM00";
                break;
            case 2:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBSTYxV0ZpVGhTTzQ";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBaVZwWW12aDBoejg";
                break;
            case 4:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMnFsdkZ6bFVxTVE";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBQWhWTDVGaDhOM2s";
                break;
            case 6:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBSTBOSWhfZm1jQlU";
                break;
            case 7:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBbi1oam9IbFI4QWc";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }


    public String otherDocs(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBUVptOTdWelc1N1U";
                break;
            case 2:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBTTFRcGRNUkUwN1k";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMUJPczdJR0RLVnc";
                break;
            case 4:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBRDlmc1FyNENqZjQ";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBd3pCT2pkaVJMakU";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }

    public String otherName(int slide)
    {
        String lol=" ";
        switch (slide)
        {
            case 1:
                lol="Single Charts";
                break;
            case 2:
                lol="Dual Charts";
                break;
            case 3:
                lol="Phy lab manual";
                break;
            case 4:
                lol="Thomas's Calculus Soln (11th Edition)";
                break;
            case 5:
                lol="Graduation Requirements";
                break;
            default:
                lol="Couldnt quite get d name";
        }
        return lol;
    }

    public String timetable()
    {
        String url="https://drive.google.com/open?id=0B6g3rUcjc3hBaE03UlBaa0NQYzA";
        return url;
    }


    public String qpapers(int slide)
    {
        String url="lol";
        switch (slide)
        {
            case 1:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBMnJzaFBTeDl3bGc";
                break;
            case 2:
//                url="https://drive.google.com/open?id=0B6g3rUcjc3hBb1cwcjF6NGZKNzA";
                break;
            case 3:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBeW9HZklQNHRjMzQ";
                break;
            case 4:
//                url="https://drive.google.com/open?id=0B6g3rUcjc3hBbjJGbm5fMnUtWWc";
                break;
            case 5:
                url="https://drive.google.com/open?id=0B6g3rUcjc3hBZFBkM2xleEFGOW8";
                break;
            case 6:
//                url="https://drive.google.com/open?id=0B6g3rUcjc3hBUE9lc21ZZzRXWUE";
                break;
            case 7:
//                url="https://drive.google.com/open?id=0B6g3rUcjc3hBVnJ0THVwOXBFLU0";
                break;
            default:
                url="www.google.com";
        }
        return url;
    }


    public String qpaperName(int slide)
    {
        String lol=" ";
        switch (slide)
        {
            case 1:
                lol="General Chemistry 2012";
                break;
            case 2:
                lol="Maths-I 2012";
                break;
            case 3:
                lol="MEOW 2011";
                break;
            case 4:
                lol="EG 2011";
                break;
            case 5:
                lol="Gen Bio 2012";
                break;
            case 6:
                lol="Tech Rep 2014";
                break;
            case 7:
                lol="Workshop 2012";
                break;
            default:
                lol="lol";
        }
        return lol;
    }

    public void getDownloadUrl(String url)
    {
        downloadUrl=url.substring(0,25)+"uc"+url.substring(29)+"&export=download";
    }

    public void download(View view)
    {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
        request.setDescription("There is a Ghot in every one");
        request.setTitle(name);

        request.allowScanningByMediaScanner();
        request.setVisibleInDownloadsUi(true);
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI|DownloadManager.Request.NETWORK_MOBILE);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, name + ".pdf");

        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        Toast.makeText(DisplaySlides.this, "Downloading....", Toast.LENGTH_LONG).show();

        manager.enqueue(request);

    }

    private class mwebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);

            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progress.setTitle("Loading");
            progress.setMessage("Please wait getting slides for you...");
            if (check) {
                progress.show();
                check=false;
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            count++;
            progress.setProgress(count);
            if(count>6)
            progress.dismiss();
        }
    }

}

