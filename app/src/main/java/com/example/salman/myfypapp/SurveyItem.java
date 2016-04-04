package com.example.salman.myfypapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by salman on 14/12/15.
 */
public class SurveyItem {
    private String name;
    private float foodRating, serviceRating;

    private boolean regCust;

    public SurveyItem(String name, float f, float g, boolean regCust)
    {
        this.name=name;
        this.foodRating=f;
        this.serviceRating=g;
        this.regCust=regCust;
    }

    public String getName() {
        return name;
    }
}

class SurveyAdapter extends ArrayAdapter<SurveyItem> {
    private ArrayList<SurveyItem> objects;
    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public SurveyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.objects = (ArrayList<SurveyItem>) objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if(convertView==null) {
            convertView=inflater.inflate(R.layout.list_item_view, null);
        }

        SurveyItem surveyItem = objects.get(position);
        ((TextView)convertView.findViewById(R.id.nameTextView1)).setText(surveyItem.getName());

        return convertView;

    }
}


