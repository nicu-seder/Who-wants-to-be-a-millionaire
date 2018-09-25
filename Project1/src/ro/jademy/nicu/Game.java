package ro.jademy.nicu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static final int MAX_LEVEL = 4;

    private Random random = new Random();
    private boolean fiftyFiftyOptionUsed = false;
    private int currentLevel = 1;
    private List<Question> gameQuestions = new ArrayList<>();

    public Game(List<Question> gameQuestions) {
        this.gameQuestions.addAll(gameQuestions);
    }


    public void askQuestion() {
        //show question on screen
        for (Question question : gameQuestions) {
            showQuestion(question);
            checkAnswer(question);

        }
    }

    public void showFiftyFifty() {
        System.out.println("-------------------------");
        System.out.println("Press 5 for fifty / fifty");
        System.out.println("-------------------------");
    }

    //in progress
    public void checkAnswer(Question question) {
        Scanner scan = new Scanner(System.in);
        Answer chosenAnswer;
        Answer correctAnswer;
        int option;
        if (!fiftyFiftyOptionUsed) {
            showFiftyFifty();
        }
        do {
            option = scan.nextInt();
        } while (option > 5 || option < 1);
        correctAnswer = question.getCorrectAnswer();
        chosenAnswer = question.getAnswerList().get(option - 1);
        if (chosenAnswer.equals(correctAnswer)) {
            System.out.println("FELICITARI, AI RASPUNS CORECT!");
        } else if (option == 5) {
            fiftyFiftyOption(question);
            do {
                option = scan.nextInt();
            } while (option > 2 || option > 1);
        } else {
            System.out.println("AI PIERDUT!");
            System.exit(0);
        }
    }


    private void showQuestion(Question question) {
        System.out.println("Level: " + question.getDifficultyLevel());
        System.out.println(question.getQuestion());
        for (Answer answer : question.getAnswerList()) {
            System.out.println(answer.getAnswer());
        }

    }

    public List<Question> getGameQuestions() {
        return gameQuestions;
    }

    public void setGameQuestions(List<Question> gameQuestions) {
        this.gameQuestions = gameQuestions;
    }

    //first version
    public void fiftyFiftyOption(Question question) {
        List<Answer> twoOptionAnswers = new ArrayList<>();
        List<Answer> listOfWrongAnswers = new ArrayList<>();

        for (Answer answer : question.getAnswerList()) {
            if (!answer.isCorrect()) {
                listOfWrongAnswers.add(answer);
            }
        }

        twoOptionAnswers.add(question.getCorrectAnswer());
        twoOptionAnswers.add(listOfWrongAnswers.get(random.nextInt(2)));

        for (Answer answer : twoOptionAnswers) {
            System.out.println(answer.getAnswer());
        }
    }

    public void answerQuestion() {
        // get user input and check if correct
    }

}
