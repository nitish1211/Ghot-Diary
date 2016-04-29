package com.napps.acads.ghotdiary.Sem11;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.napps.acads.ghotdiary.R;

class CustomAdapter extends ArrayAdapter<String> {

 int[] images={R.drawable.nalanda,R.drawable.lecture,R.drawable.handout,R.drawable.tt,R.drawable.practice,R.drawable.pdf,R.drawable.prof,R.drawable.feedback};

     public CustomAdapter(Context context, String[] item) {
         super(context,R.layout.custom_home, item);
     }
    
     @Override
     public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myinflater =LayoutInflater.from(getContext());
         View customView=myinflater.inflate(R.layout.custom_home, parent, false);

         String temp=getItem(position);
         TextView name=(TextView) customView.findViewById(R.id.name);
         ImageView img=(ImageView) customView.findViewById(R.id.img);

         name.setText(temp);
         img.setImageResource(images[position]);
         return customView;
     }

 }




