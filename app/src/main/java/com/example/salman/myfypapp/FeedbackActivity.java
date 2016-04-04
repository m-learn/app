package com.example.salman.myfypapp;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;

import java.util.ArrayList;

public class FeedbackActivity extends Activity {

    EditText nameEditText;
    RatingBar foodRatingBar, serviceRatingBar;
    CheckBox regularCustomerCheckbox;
    Button submitButton;
    ListView listView;
    SurveyAdapter adapter;

    ArrayList<SurveyItem> survey=new ArrayList<SurveyItem>();

    View.OnClickListener submitButtonListener= new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            SurveyItem s= new SurveyItem(
                    nameEditText.getText().toString(),
                    foodRatingBar.getRating(),
                    serviceRatingBar.getRating(),
                    regularCustomerCheckbox.isChecked()
            );

            adapter.add(s);

        }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_feedback);
        nameEditText = (EditText)findViewById(R.id.editText);
        foodRatingBar = (RatingBar)findViewById(R.id.ratingBar);
        serviceRatingBar = (RatingBar)findViewById(R.id.ratingBar2);
        regularCustomerCheckbox = (CheckBox)findViewById(R.id.checkBox);
        submitButton = (Button)findViewById(R.id.button);
        listView=(ListView)findViewById(R.id.listView);

        survey.add(new SurveyItem("Salman",1,3,true));


        adapter = new SurveyAdapter(this, android.R.layout.simple_list_item_1, survey);
        listView.setAdapter(adapter);
        submitButton.setOnClickListener(submitButtonListener);

    }





}

