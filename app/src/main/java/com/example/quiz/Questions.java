package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class Questions {

    private static List<QuestionList> javaQuestions() {

        final List<QuestionList> questionsList = new ArrayList<>();

        // Ordre des question: question-options-réponse
        final QuestionList question1 = new QuestionList("Quelle est la taille de la varaiable int?", "16 bit", "8 bit", "32 bit", "64 bit", "32 bit");
        final QuestionList question2 = new QuestionList("Quelle est la valeur par défault de la variable booléenne?", "true", "false", "null", "not defined", "false");
        final QuestionList question3 = new QuestionList("Quelle est la valeur par défaut d'une variable d'instance?", "Dépend du type de variable", "null", "0", "non attribué", "Dépend du type de variable");
        final QuestionList question4 = new QuestionList("Qui est un mot réservé dans le langage de programmation Java?", "method", "native", "reference", "array", "native");
        final QuestionList question5 = new QuestionList("Lequel des éléments suivants n'est PAS un mot-clé ou un mot réservé en Java?", "if", "then", "goto", "while", "then");
        final QuestionList question6 = new QuestionList("Quel concept de Java est un moyen de convertir des objets du monde réel en termes de classe?", "Polymorphisme", "Encapsulation", "Abstraction", "Héritage", "Abstraction");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);

        return questionsList;
    }

    private static List<QuestionList> htmlQuestions() {

        final List<QuestionList> questionsLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("Que veut dire HTML?", "Hyper Text Markup Language", "High Text Markup Language", "Hyper Tabular Markup Language", "Aucune de ces réponses", "Hyper Text Markup Language");
        final QuestionList question2 = new QuestionList("Quelle balise utilise-t'on pour déclarer un paragraphe?", "<TD>", "<br>", "<P>", "<TR>", "<P>");
        final QuestionList question3 = new QuestionList("Quelle balise utilise-t'on pour déclarer une liste descriptive?", "<LL>", "<DD>", "<DL>", "<DS>", "<DL>");
        final QuestionList question4 = new QuestionList("Quelle balise utilise-t'on pour déclarer le plus gros titre", "<head>", "<large>", "<h6>", "<heading>", "<h1>");
        final QuestionList question5 = new QuestionList("La balise HTML qui spécifie un style CSS intégré dans un élément est appelée", "Design", "Style", "src", "Define", "Style");
        final QuestionList question6 = new QuestionList("HTML est considéré comme", "Langage de programmation", "Langage POO", "Le language le plus puissant sur Terre", "Langage de balisage", "Langage de balisage");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionList> reactQuestions() {

        final List<QuestionList> questionsLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question2 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question3 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question4 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question5 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question6 = new QuestionList("?", "", "", "", "", "");


        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionList> unityQuestions() {

        final List<QuestionList> questionsLists = new ArrayList<>();

        final QuestionList question1 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question2 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question3 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question4 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question5 = new QuestionList("?", "", "", "", "", "");
        final QuestionList question6 = new QuestionList("?", "", "", "", "", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    public static List<QuestionList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "java":
                return javaQuestions();
            case "react":
                return reactQuestions();
            case "unity":
                return unityQuestions();
            default:
                return htmlQuestions();
        }
    }
}
