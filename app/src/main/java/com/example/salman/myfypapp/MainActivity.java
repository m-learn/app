package com.example.salman.myfypapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showGreetings(View view)
    {
        String button_text;
        button_text = ((Button) view) .getText() .toString ();
        if (button_text.equals("Learn"))
        {
            Intent intent = new Intent(this,HtmlStart.class);
            startActivity(intent);

        }
        else if (button_text.equals("Quiz"))
        {
            Intent intent = new Intent(this,QuestionActivity.class);
            startActivity(intent);
        }
        else if (button_text.equals("Feedback"))
        {
            Intent intent = new Intent(this,FeedbackActivity.class);
            startActivity(intent);
        }else if (button_text.equals("High Score"))
        {
            Intent intent = new Intent(this,HighScoreActivity.class);
            startActivity(intent);
        }

    }
}
