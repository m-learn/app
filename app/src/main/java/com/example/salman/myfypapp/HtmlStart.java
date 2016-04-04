package com.example.salman.myfypapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HtmlStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_html);
    }

    public void startlesson(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("INTRODUCTION TO HTML")) {
            Intent intent = new Intent(this, IntroHtml.class);
            startActivity(intent);

        } else if (button_text.equals("HTML BASICS")) {
            Intent intent = new Intent(this, HtmlBasic.class);
            startActivity(intent);
        } else if (button_text.equals("HTML ELEMENTS")) {
            Intent intent = new Intent(this, HtmlElements.class);
            startActivity(intent);
        } else if (button_text.equals("RECAP PART 1")) {
            Intent intent = new Intent(this, RecapP1.class);
            startActivity(intent);
        } else if (button_text.equals("HTML RECAP TASK")) {
            Intent intent = new Intent(this, TestHtml.class);
            startActivity(intent);
        } else if (button_text.equals("HTML TASK")) {
            Intent intent = new Intent(this, TaskOne.class);
            startActivity(intent);
        }
    }
}