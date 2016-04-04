package com.example.salman.myfypapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArrayScore extends ArrayAdapter<Score> {

    private final Context context;
    private final Score[] values;

    public ArrayScore (Context context, Score[] values) {
        super(context, R.layout.activity_score, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_score, parent,
                false);
        TextView scoreTxt = (TextView) rowView.findViewById(R.id.scoreTxt);
        //TextView dateTxt = (TextView) rowView.findViewById(R.id.dateTxt);
        if (position == 0) {
            scoreTxt.setText("No. of Question");
            //dateTxt.setText("Date");
        } else {
            scoreTxt.setText(values[position - 1].getScore() + "");
            //dateTxt.setText(values[position - 1].getTime());
        }

        return rowView;
    }
}
