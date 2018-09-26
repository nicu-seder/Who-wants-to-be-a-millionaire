package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static List<Question> questions = new ArrayList<>();
    private static Random RANDOM = new Random();

    public static void main(String[] args) {

        initQuestions();
        List<Question> gameQuestions = getGameQuestions();
        // de fiecare data cand initializam jocul, primim un subset nou (random) de intrebari
        Game game = new Game(gameQuestions);
        game.askQuestion();
        //game.showFiftyOptions(gameQuestions.get(0));

    }

    private static void initQuestions() {
        List<AbstractAnswer> answer1 = new ArrayList<>();
        answer1.add(new CorrectAnswer("A. Paris"));
        answer1.add(new WrongAnswer("B. Bucharest"));
        answer1.add(new WrongAnswer("C. Budapest"));
        answer1.add(new WrongAnswer("D. Marseille"));
        questions.add(new Question("Capitala Frantei este:", 1, answer1));


        List<AbstractAnswer> answer2 = new ArrayList<>();
        answer2.add(new WrongAnswer("A. Africa"));
        answer2.add(new CorrectAnswer("B. Asia"));
        answer2.add(new WrongAnswer("C. North America"));
        answer2.add(new WrongAnswer("D. Antarctica"));
        questions.add(new Question("Cel mai mare continent este:", 2, answer2));

        List<AbstractAnswer> answer3 = new ArrayList<>();
        answer3.add(new WrongAnswer("A. 1899"));
        answer3.add(new WrongAnswer("B. 1900"));
        answer3.add(new CorrectAnswer("C. 1918"));
        answer3.add(new WrongAnswer("D. 1919"));
        questions.add(new Question("Marea Unire s-a realizat in:", 3, answer3));


        List<AbstractAnswer> answer4 = new ArrayList<>();
        answer4.add(new WrongAnswer("A. 8884m"));
        answer4.add(new WrongAnswer("B. 8488m"));
        answer4.add(new CorrectAnswer("C. 8848m"));
        answer4.add(new WrongAnswer("D. 8888m"));
        questions.add(new Question("Cel mai inalt munte din lume are:", 4, answer4));


        List<AbstractAnswer> answer5 = new ArrayList<>();
        answer5.add(new CorrectAnswer("A. Marte"));
        answer5.add(new WrongAnswer("B. Saturn"));
        answer5.add(new WrongAnswer("C. Jupiter"));
        answer5.add(new WrongAnswer("D. Neptun"));
        questions.add(new Question("Ce planeta este supranumita Planeta Rosie?", 1, answer5));


        List<AbstractAnswer> answer6 = new ArrayList<>();
        answer6.add(new WrongAnswer("A. China"));
        answer6.add(new CorrectAnswer("B. Japonia"));
        answer6.add(new WrongAnswer("C. Rusia"));
        answer6.add(new WrongAnswer("D. Moldova"));
        questions.add(new Question("Ce tara e supranumita Tara Soarelui Rasare?", 2, answer6));


        List<AbstractAnswer> answer7 = new ArrayList<>();
        answer7.add(new WrongAnswer("A. New York"));
        answer7.add(new WrongAnswer("B. Moscova"));
        answer7.add(new CorrectAnswer("C. Tokyo"));
        answer7.add(new WrongAnswer("D. Montreal"));
        questions.add(new Question("Cel mai populat oras din lume este:", 3, answer7));


        List<AbstractAnswer> answer8 = new ArrayList<>();
        answer8.add(new WrongAnswer("A. Rin"));
        answer8.add(new WrongAnswer("B. Dunare"));
        answer8.add(new CorrectAnswer("C. Volga"));
        answer8.add(new WrongAnswer("D. Sena"));
        questions.add(new Question("Care este cel mai lung fluviu din Europa:", 4, answer8));

    }


    private static List<Question> getGameQuestions() {
        List<Question> gameQuestions = new ArrayList<>();
        for (int i = 1; i <= Game.MAX_LEVEL; i++) {
            gameQuestions.add(getQuestionForLevel(i));
        }
        return gameQuestions;
    }


    public static Question getQuestionForLevel(int level) {
        // parcurgem lista
        // gasim o sublista cu intrebari de nivelul x
        // alegem un random din sublista
        List<Question> subList = new ArrayList<>();
        for (Question question : questions) {
            if (question.getDifficultyLevel() == level) {
                subList.add(question);
            }
        }
        return randomize(subList);
    }


    public static Question randomize(List<Question> listOfQuestions) {
        int index = RANDOM.nextInt(listOfQuestions.size());
        return listOfQuestions.get(index);

    }

}