package com.example.salman.myfypapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class HighScoreActivity extends Activity {
    private ListView scoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        scoreList = (ListView) findViewById(R.id.scoreList);
        setData();
    }

    private void setData() {
        SqlDB sqlDB = new SqlDB(this);
        ArrayList<Score> highScores = sqlDB.getTop10();
        scoreList.setAdapter(new ArrayScore(this, highScores
                .toArray(new Score[0])));
    }




}
