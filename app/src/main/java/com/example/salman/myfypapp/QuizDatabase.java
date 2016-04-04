package com.example.salman.myfypapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizDatabase {
    public static List<Question> GenerateQuestion() {
        List<Question> questions = new ArrayList<Question>();
        questions //accessing the array list
                .add(new Question(//creating a new object of class question
                        "What does HTML stand for? ",//entering the values for the question
                        "A) Hyper Text Markup Language", "B) Hyperlinks and Text Markup Language ",
                        "C) Home Tool Markup Language", "D) Hyperlink Markup Language", 1));
        questions.add(new Question(
                "Choose the correct HTML element which displays a paragraph: ?",
                "A) <Title> ", "B) <Paragraph> ", "C) <P> ",
                "D) <Head> ", 3));
        questions
                .add(new Question(
                        " What is the difference between HTML and CSS?",
                        "A) CSS deals with the function of the site and HTML the form ", "B) CSS is a markup language unlike HTML ", "C) HTML deals with the function of the site and CSS the form",
                        "D) There is no difference", 3));
        questions
                .add(new Question(
                        " Which HTML5 element is used to specify a title for the document?",
                        "A) <Title>", "B) <bottom>",
                        "C) <section>", "D) <Header> ", 1));
        questions
                .add(new Question(
                        "Ideally where is the following <h1>This is a Heading</h1>, used?",
                        "A) <head>", "B) <title>", "C) <body> ",
                        "D) <footer>", 3));
        questions
                .add(new Question(
                        "In the HTML page structure which section is shown by the browser?",
                        "A) <body> .. </body>", "B) <head> .. </head> ", "C) <title> .. </title> ", "D) A,B and C ", 1));
        questions
                .add(new Question(
                        " What does CSS stand for?",
                        "A) Colorful Style Sheets ", "B) Cascading Style Sheets ",
                        "C) Creative Style Sheets", "D) Computer Style Sheets", 2));

        questions
                .add(new Question(
                                "To display a document correctly, the browser must know both type and version. Which below is the correct Doctype?",
                        "A) <!DOCTYPE>", "B) <!DOCTYPE html>",
                        "C) <DOCTYPE Start>", "D) A or B ", 2));
        Collections.shuffle(questions);
        return questions;
    }

}
