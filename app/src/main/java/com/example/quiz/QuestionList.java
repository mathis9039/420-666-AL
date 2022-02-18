package com.example.quiz;

public class QuestionList {

    private String question, option1, option2, option3, option4, reponseUser, answer;

    public QuestionList(String question, String option1, String option2, String option3, String option4, String reponse, String userGuess) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.reponseUser = reponseUser;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getReponseUser() {
        return reponseUser;
    }

    public String getAnswer() {
        return answer;
    }

    public QuestionList(String answer) {
        this.answer = answer;
    }
}
