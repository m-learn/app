package com.example.salman.myfypapp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class QuestionActivity extends Activity {
    private List<Question> questions;
    private int currentQuestion = 0;
    private TextView questionTextView;
    private Button aButton;
    private Button bButton;
    private Button cButton;
    private Button dButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTextView = (TextView) findViewById(R.id.questionTextView);
        aButton = (Button) findViewById(R.id.buttona);
        bButton = (Button) findViewById(R.id.buttonb);
        cButton = (Button) findViewById(R.id.buttonc);
        dButton = (Button) findViewById(R.id.dButton);


        questions = QuizDatabase.GenerateQuestion();
        showQuestion(currentQuestion);
    }

    private void showQuestion(int q) {//this is called in the select answer method below!!!
        if (q < 0 || q >= questions.size())//if the number of question is less than the amount of questions in the arraylist
        {
//this method if for once you've done every question then the questions ends
            System.exit(0);

        }
        //else get another question
        Question question = questions.get(q);
        questionTextView.setText(question.getQuestion());//text that views the question
        aButton.setText(question.getChoice1());//get choice one and set it as text in button1
        bButton.setText(question.getChoice2());//same as above
        cButton.setText(question.getChoice3());
        dButton.setText(question.getChoice4());
        aButton.setEnabled(true);//after setting the text(above)..enable the button so it shows on the screen.
        bButton.setEnabled(true);
        cButton.setEnabled(true);//same as above)
        dButton.setEnabled(true);
    }

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.question, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

    public void selectAnswer(View view) {
        int choice = 0;//the intiger for the correct answer


        String ans = null;//this stores the correct question (A,B,C or D)..below


        if (view.equals(aButton))
            choice = 1;
        if (view.equals(bButton))
            choice = 2;
        if (view.equals(cButton))
            choice = 3;
        if (view.equals(dButton))
            choice = 4;
        Question question = questions.get(currentQuestion);//getting the question thats being asked
        if (question.getChoice() == choice) {
            //if (1==1) then currentquestion++ and if 1==2 (wrong answer) then else....
            currentQuestion++;//counting question (incrementing ...to see if the number of questions is more than you have
            showQuestion(currentQuestion);//calling the show questions method above
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("");

            if(question.getChoice()==1)//this calls the getChoice method from Question class (from Question class)
            {
                ans = "A";//this saves the right question in ans variable above

            } else if(question.getChoice()==2)
            {
                ans = "B";

            } else if(question.getChoice()==3)
            {
                ans = "C";

            } else if(question.getChoice()==4)
            {
                ans = "D";

            }
            builder.setMessage("Sorry \n Correct answer was:" + ans );//this shows the user what answer it was (when the wrong one was selected)
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    quitGame();
                }
            });

            // Create the AlertDialog
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    private void quitGame() {
        SqlDB sqlDB = new SqlDB(this);
        sqlDB.insertScore(currentQuestion);
        System.exit(0);
    }



}

