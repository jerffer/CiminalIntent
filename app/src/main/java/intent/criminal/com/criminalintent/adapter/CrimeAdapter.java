package intent.criminal.com.criminalintent.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.ArrayList;

import intent.criminal.com.criminalintent.R;
import intent.criminal.com.criminalintent.model.Crime;

/**
 * Created by Sunny on 2016/4/10.
 */
public class CrimeAdapter extends ArrayAdapter<Crime> {

    public CrimeAdapter(Context c, ArrayList<Crime> crimes) {
        super(c, 0, crimes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // if we are't given a view, inflate one.
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.list_item_crime, null);
        }


        Crime c = getItem(position);

        TextView titleView = (TextView)convertView.findViewById(R.id.crime_list_item_title);
        TextView dateView = (TextView)convertView.findViewById(R.id.crime_list_item_date);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.crime_list_item_solved);

        titleView.setText(c.getTitle());
        dateView.setText(c.getDate().toString());
        cb.setChecked(c.isSolved());

        return  convertView;

    }
}
