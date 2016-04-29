package com.napps.acads.ghotdiary.Sem11;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.napps.acads.ghotdiary.R;


public class CustomList extends ArrayAdapter<String> {


    private LayoutInflater mInflater;
    private final Context context;

    int[]pic;
    int t=-1;
    public CustomList(Context context, String[] item,int []pic) {
        super(context, R.layout.custom_slides, item);
        this.pic=pic;
        this.context=context;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Animation anim1 =AnimationUtils.loadAnimation(getContext(),R.anim.up_from_bottom);
        Animation anim2 =AnimationUtils.loadAnimation(getContext(),R.anim.down_from_top);
//        Animation anim3 =AnimationUtils.loadAnimation(getContext(),R.anim.card_lift);

        String str= getItem(position);
        final Holder holder;

        if(convertView==null)
        {
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.custom_slides,parent,false);
            holder = new Holder();
            holder.name=(TextView) convertView.findViewById(R.id.name);

            holder.img=(ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }
        else
        {
            holder=(Holder) convertView.getTag();
        }

        holder.name.setText(str);

        holder.img.setImageResource(pic[position]);

        if(t<position) {
            convertView.startAnimation(anim1);
//            convertView.startAnimation(anim3);
        }
        else
        convertView.startAnimation(anim2);

        t=position;

        return convertView;
    }

    public class Holder
    {
        public TextView name;
        public ImageView img;
    }
}
