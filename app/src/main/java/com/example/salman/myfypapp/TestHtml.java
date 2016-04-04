package com.example.salman.myfypapp;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class TestHtml extends Activity {

    public void showToast (View view) {
        Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
    }

    ImageView imgFront;
    ImageView imgBack;
    Button btnFlip;

    boolean isBackVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flip);

        imgFront = (ImageView)findViewById(R.id.imgFront);
        imgBack = (ImageView)findViewById(R.id.imgBack);
        btnFlip = (Button)findViewById(R.id.btnFlip);

        final AnimatorSet setRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flip_right_out);


        final AnimatorSet setLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                R.animator.flight_left_in);


        btnFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isBackVisible){
                    setRightOut.setTarget(imgFront);
                    setLeftIn.setTarget(imgBack);
                    setRightOut.start();
                    setLeftIn.start();
                    isBackVisible = true;
                }
                else{
                    setRightOut.setTarget(imgBack);
                    setLeftIn.setTarget(imgFront);
                    setRightOut.start();
                    setLeftIn.start();
                    isBackVisible = false;
                }
            }
        });
    }




}
