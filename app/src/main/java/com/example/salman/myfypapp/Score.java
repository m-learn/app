package com.example.salman.myfypapp;

public class Score {
    private int score;
    private String time;

    public Score(int score, String time) {
        super();
        this.score = score;
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}