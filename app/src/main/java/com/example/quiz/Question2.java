package com.example.quiz;

import java.util.List;

public class Question2 {
    public String question;
    public List<String> options;
    public String answer;

    public Question2() {
    }

    public Question2(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption(int index) {
        return options.get(index);
    }

    public String getAnswer() {
        return answer;
    }
}
