package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Here we start initializing the list of questions and answers
 */
public class Game {
    public static int score = 0;
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();

    /**
     * All the questions alongside wit their answers are initialized
     * The same list of answers is used to initialize the answers for each question.
     * After each use, the list is cleared and initialized again with new values for the respective question
     */
    public Game(){
        answers.add(new Answer("Nicu",true));
        answers.add(new Answer("Paty",false));
        answers.add(new Answer("Radu",false));
        answers.add(new Answer("Filip",false));
        questions.add(new Question("What is your name?",1,answers));

        answers.clear();

        answers.add(new Answer("Zlatan",false));
        answers.add(new Answer("Robinho",false));
        answers.add(new Answer("Messi",true));
        answers.add(new Answer("Ronaldo",false));
        questions.add(new Question("Best footabll player?",2,answers));

        answers.clear();

    }

    /**
     * It shows the list of question we have in the array alongside with all the answers
     */
    public void showQuestionsAnswers(){
        for(Question question:questions){
            System.out.println(question.getQuestion());
            List<Answer> list = question.getAnswerList();
            for(Answer answer:list){
                System.out.println(answer.getAnswer());
            }
        }
    }

    /**
     * Question is asked and user input is expected (ex: 1,2,3,4). Based on the selected option
     * the selection is compared to the right answer. If correct, message is shown and score is increased
     */
    public void askQuestion(){
        Scanner scanner = new Scanner(System.in);
        int chosenOption;
        for(Question question:questions){
            System.out.println(question.getQuestion());
            question.showAnswers();
            chosenOption = scanner.nextInt();
            Answer chosenAnswer = question.getAnswerList().get(chosenOption-1);
            Answer correctAnswer = question.getCorrectAnswer();
            if(answerIsCorrect(chosenAnswer,correctAnswer)){
                score++;
                System.out.println("CORRECT ANSWER");
            }else{
                System.out.println("WRONG ANSWER");
            }
        }
    }

    /**
     * the score for the respective game is printed
     */
    public void showScore(){
        System.out.println(score);
    }

    /**
     *
     * @param answer1 the answer chosen as option when question is asked
     * @param answer2 the correct answer for the asked question
     * @return  if the 2 questions have the same value for correct than true is returned
     */
    public boolean answerIsCorrect(Answer answer1, Answer answer2){
        return answer1.equals(answer2);
    }
}
