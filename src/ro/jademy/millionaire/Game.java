package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Here we start initializing the list of questions and answers
 */
public class Game {

    public static final int MAX_LEVEL = 4;
    private Random random = new Random();
    Scanner scan = new Scanner(System.in);
    private boolean fiftyFiftyOptionUsed = false;
    private int currentLevel = 1;
    private List<Question> gameQuestions = new ArrayList<>();
    private boolean fiftyOptionUsed = false;

    public Game(List<Question> gameQuestions) {
        this.gameQuestions.addAll(gameQuestions);
    }


    public void askQuestion() {
        //show question on screen
        for (Question question : gameQuestions) {
            //it shows the question with its answers on the screen
            showQuestion(question);

            //it checks if fifty fifty option was used allready
            checkIfHelpingOptionUsed();

            //it checks if the chosen answer is correct
            answerQuestion(question);
        }
    }

    public void answerQuestion(Question question) {
        //For each question we retain the correct one in correctAnswer reference variable
        AbstractAnswer correctAnswer = question.getCorrectAnswer();
        //The answer we chose from the options
        AbstractAnswer chosenAnswer;
        //The option the user choose (1-4 for questions, 5 for 50/50 option)
        int option;
        //We get the input from the user (for questions 1-4)
        option = userInput();
        //We check if the user chose to answer the question or 50.50 option was selected
        if(option != 5) {
            chosenAnswer = question.getAnswerList().get(option - 1);
            //We check if the chosen option resemblence the correct one
            checkIfAnswerIsCorrect(chosenAnswer,correctAnswer);
        }
        //The user chose to use his 50/50 option
        else {
            //We check if he has already chose this option as it is available only once
            if (!fiftyOptionUsed){
                showFiftyOptions(question);
            //We get the input from the user for the 2 remained questions(1-2)
            option = userInputFiftyFifty();
            chosenAnswer = FiftyFifty(question).get(option - 1);
            //We check if the chosen option resemblence the correct one
            checkIfAnswerIsCorrect(chosenAnswer,correctAnswer);
            //50/50 option is marked as used as it is available only once
            fiftyOptionUsed = true;
        }
        else{
                System.out.println("-------------------------");
                System.out.println("Already used 50/50 option");
                System.out.println("-------------------------");
                //Recursion is used if the player keep selecting for te 50/50 option - message that is not available shown and the same question(through recursion) appears
                showQuestion(question);
                answerQuestion(question);
            }
        }
    }

    //It checks if the 2 answers received as parameters are the same and prints a message
    public void checkIfAnswerIsCorrect(AbstractAnswer chosenAnswer, AbstractAnswer correctAnswer){
        if (chosenAnswer instanceof CorrectAnswer) {
            System.out.println("FELICITARI, AI RASPUNS CORECT!");
        } else {
            System.out.println("AI PIERDUT!");
            System.exit(0);
        }
    }

    //Wait for user imput regarding the answers for the 4 questions
    public int userInput(){
        int option;
        do {
            option = scan.nextInt();
        } while (option > 5 || option < 1);
        return option;
    }

    //Wait for user imput regarding the answers after 50/50 option was called
    public int userInputFiftyFifty(){
        int option;
        do {
            option = scan.nextInt();
        } while (option > 2 || option < 1);
        return option;
    }


    private void showQuestion(Question question) {
        System.out.println("Level: " + question.getDifficultyLevel());
        System.out.println(question.getQuestion());
        for (AbstractAnswer answer : question.getAnswerList()) {
            System.out.println(answer.getAnswer());
        }
    }




    //it returns a list with 2 options, one correct and one wrong
    public List<AbstractAnswer> FiftyFifty(Question question){
        //when found in the list, the correct answer is displayed and marked as used.
        boolean correctAnswerUsed = false;
        //only one out of three wrong answers should be displayed. First wrong answer found is displayed and marked as used
        boolean wrongAnswerUsed = false;
        List<AbstractAnswer> listOfFiftyFiftyOptions = new ArrayList<>();

        for(AbstractAnswer answer:question.getAnswerList()){
            if(answer instanceof CorrectAnswer){
                if(!correctAnswerUsed){
                    correctAnswerUsed = true;
                    listOfFiftyFiftyOptions.add(answer);
                }
            }else if(answer instanceof WrongAnswer){
                if(!wrongAnswerUsed){
                    wrongAnswerUsed = true;
                    listOfFiftyFiftyOptions.add(answer);
                }
            }
        }
        return listOfFiftyFiftyOptions;
    }

    //it loops through the 2 fifty fifty options and prints them
    public void showFiftyOptions(Question question){
        for(AbstractAnswer answer:FiftyFifty(question)){
            System.out.println(answer.getAnswer());
        }
    }


    //It checks if 50/50 is available
    public void checkIfHelpingOptionUsed(){
        if(!fiftyOptionUsed){
            showFiftyFifty();
        }
    }
    //Message if 50/50 option is available
    public void showFiftyFifty() {
        System.out.println("-------------------------");
        System.out.println("Press 5 for fifty / fifty");
        System.out.println("-------------------------");
    }

    public List<Question> getGameQuestions() {
        return gameQuestions;
    }

    public void setGameQuestions(List<Question> gameQuestions) {
        this.gameQuestions = gameQuestions;
    }


}
