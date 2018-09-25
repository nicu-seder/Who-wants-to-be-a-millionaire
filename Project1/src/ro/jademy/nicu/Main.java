package ro.jademy.nicu;

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
        //game.fiftyFiftyOption(game.getGameQuestions().get(1));
    }

    private static void initQuestions() {
        List<Answer> answer1 = new ArrayList<>();
        answer1.add(new Answer("A. Paris", true));
        answer1.add(new Answer("B. Bucharest"));
        answer1.add(new Answer("C. Budapest"));
        answer1.add(new Answer("D. Marseille"));
        questions.add(new Question("Capitala Frantei este:", 1, answer1));

        List<Answer> answer2 = new ArrayList<>();
        answer2.add(new Answer("A. Africa"));
        answer2.add(new Answer("B. Asia", true));
        answer2.add(new Answer("C. North America"));
        answer2.add(new Answer("D. Antarctica"));
        questions.add(new Question("Cel mai mare continent este:", 2, answer2));

        List<Answer> answer3 = new ArrayList<>();
        answer3.add(new Answer("A. 1899"));
        answer3.add(new Answer("B. 1900"));
        answer3.add(new Answer("C. 1918", true));
        answer3.add(new Answer("D. 1919"));
        questions.add(new Question("Marea Unire s-a realizat in:", 3, answer3));

        List<Answer> answer4 = new ArrayList<>();
        answer4.add(new Answer("A. 8884m"));
        answer4.add(new Answer("B. 8488m"));
        answer4.add(new Answer("C. 8848m", true));
        answer4.add(new Answer("D. 8888m"));
        questions.add(new Question("Cel mai inalt munte din lume are:", 4, answer4));

        List<Answer> answer5 = new ArrayList<>();
        answer5.add(new Answer("A. Marte", true));
        answer5.add(new Answer("B. Saturn"));
        answer5.add(new Answer("C. Jupiter"));
        answer5.add(new Answer("D. Neptun"));
        questions.add(new Question("Ce planeta este supranumita Planeta Rosie?", 1, answer5));

        List<Answer> answer6 = new ArrayList<>();
        answer6.add(new Answer("A. China"));
        answer6.add(new Answer("B. Japonia", true));
        answer6.add(new Answer("C. Rusia"));
        answer6.add(new Answer("D. Moldova"));
        questions.add(new Question("Ce tara e supranumita Tara Soarelui Rasare?", 2, answer6));

        List<Answer> answer7 = new ArrayList<>();
        answer7.add(new Answer("A. New York"));
        answer7.add(new Answer("B. Moscova"));
        answer7.add(new Answer("C. Tokyo", true));
        answer7.add(new Answer("D. Montreal"));
        questions.add(new Question("Cel mai populat oras din lume este:", 3, answer7));

        List<Answer> answer8 = new ArrayList<>();
        answer8.add(new Answer("A. Rin"));
        answer8.add(new Answer("B. Dunare"));
        answer8.add(new Answer("C. Volga", true));
        answer8.add(new Answer("D. Sena"));
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
//abstractizarae se realizeaza prin clase abstracte si interfete
//o clasa abstracta poate contine sau nu metode abstracte
//dc o clasa contine cel putin o metoda abstracta atunci si ea tre sa fie abstracta
//clasele abstracte nu pot fi instantiate
//pot fi mostenite
//se pune @Override
//clasele abstracte se folosesc atunci cand: sharing code among several closely related classes
//toate metodele dintr-o interfata sunt by default publice si abstracte
//orice field din interfete sunt public static final deci sunt constante. Trebuie sa fie declarate fiind final
//o interfata poate extinde mai multe interfete