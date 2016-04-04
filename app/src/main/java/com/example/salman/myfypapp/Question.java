package com.example.salman.myfypapp;


public class Question {
    /*
     * Hint
     */
    private String question;
    /*
     * Content of choice 1
     */
    private String choice1;
    /*
     * Content of choice 2
     */
    private String choice2;
    /*
     * Content of choice 3
     */
    private String choice3;
    /*
     * Content of choice 4
     */
    private String choice4;
    /*
     * Correct choice
     */
    private int choice;
//_______________________________________________
    public Question(String question, String choice1, String choice2,
                    String choice3, String choice4, int choice) {
        super();
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice = choice;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getChoice() {
        return choice;
    }//this method is used in Question activity (gives the number of the right answer)

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

}
