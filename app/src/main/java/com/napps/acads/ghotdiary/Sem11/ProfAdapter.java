package com.napps.acads.ghotdiary.Sem11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.napps.acads.ghotdiary.R;

public class ProfAdapter extends ArrayAdapter<String> {

    int t=-1;
    private LayoutInflater mInflater;
    private final Context context;
    String[] courseCode;

    public ProfAdapter (Context context, String[] item,String[] item2)
    {
        super(context, R.layout.custom_prof, item);
        courseCode=item2;
        this.context=context;

    }
public class Holder
{
   public TextView profName;
   public TextView subject;
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Animation anim1 =AnimationUtils.loadAnimation(getContext(),R.anim.up_from_bottom);
        Animation anim2 =AnimationUtils.loadAnimation(getContext(),R.anim.down_from_top);

        final Holder holder;

        if(convertView==null)
        {
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=mInflater.inflate(R.layout.custom_prof,parent,false);
            holder = new Holder();

            holder.profName=(TextView) convertView.findViewById(R.id.profName);
            holder.subject=(TextView) convertView.findViewById(R.id.subject);
            convertView.setTag(holder);
        }
        else
        {
            holder=(Holder) convertView.getTag();
        }

       holder.profName.setText(getItem(position));
       holder.subject.setText(courseCode[position]);

        if(t<position)
            convertView.startAnimation(anim1);
        else
            convertView.startAnimation(anim2);

        t=position;

        return convertView;
    }

}
