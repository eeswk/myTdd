package chap10.survey;

import java.util.List;

public class Question {
    private int number;
    private String question;
    private List<Item> itmes;

    public Question(int number, String question, List<Item> itmes) {
        this.number = number;
        this.question = question;
        this.itmes = itmes;
    }
}
