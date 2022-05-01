package com.example.quiz;

public class Question {

    public String questionID = "";
    public String question;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String answer;
    public String  reponseUser;

    public Question(String questionID, String question, String option1, String option2, String option3, String option4, String answer) {
        this.questionID = questionID;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;

        this.reponseUser = "";
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionID='" + questionID + '\'' +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                ", reponseUser='" + reponseUser + '\'' +
                '}';
    }

    public Question(){

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

    public void setReponseUser(String reponseUser) {
        this.reponseUser = reponseUser;
    }
}
