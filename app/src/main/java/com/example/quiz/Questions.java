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

        final QuestionList question1 = new QuestionList("Lequel des éléments suivants agit comme l'entrée d'un composant basé sur une classe?", "Class", "Factory", "Render", "Props", "Props");
        final QuestionList question2 = new QuestionList("Quel est le port par défaut sur lequel Webpack-server s'exécute?", "1234", "8080", "6060", "3030", "8080");
        final QuestionList question3 = new QuestionList("Laquelle des méthodes suivantes fait référence à la classe parent dans React.js?", "inherits()", "self()", "super()", "this()", "super()");
        final QuestionList question4 = new QuestionList("Lequel des éléments suivants est une API incontournable pour chaque composant React.js?", "SetinitialComponent", "renderComponent", "render", "Aucune des réponses", "renderComponent");
        final QuestionList question5 = new QuestionList("Combien d'éléments un composant de React.js valide peut renvoyer?", "1", "2", "5", "10", "1");
        final QuestionList question6 = new QuestionList("Laquelle des commandes suivantes est utilisée pour installer create-react-app?", "npm install -g create-react-app", "install -g create-react-app", "npm install -f create-react-app", "npm install create-react-app", "npm install -g create-react-app");


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

        final QuestionList question1 = new QuestionList("Un matériau physique avec une valeur de frottement de 0 donnerait l'impression d'être sur...?", "du sable", "de la glace", "de la roche", "de la gravel", "de la glace");
        final QuestionList question2 = new QuestionList("Qu'est ce qu'un GameObject?", "Un objet présent dans une scène", "Un élement de UI", "Un modèle 3D", "Un fichier", "Un objet présent dans une scène");
        final QuestionList question3 = new QuestionList("Quel est le nom du component ajouté automatiquement et toujours présent?", "Transform", "Collider", "ScriptGenerator", "C#", "Transform");
        final QuestionList question4 = new QuestionList("Que veut dire: destroy(GameObject.Find('Player'), 3f); ?", "Il désactive l'objet Player après 3 secondes", "Il supprime l'objet Player après 3 secondes", "Il efface la scène où se trouve l'objet Player", "Aucune des réponses", "Il supprime l'objet Player après 3 secondes");
        final QuestionList question5 = new QuestionList("Qu'est ce qu'une prefab?", "Un modèle 3D réalisé sur Blender", "Un template", "Un type de donnée", "toutes ces réponses", "Un template");
        final QuestionList question6 = new QuestionList("Les scripts (MonoBehaviour) peuvent-ils être ajoutés comme des components?", "Oui", "Non", "Peut-être", "Demande à François", "Oui");

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
