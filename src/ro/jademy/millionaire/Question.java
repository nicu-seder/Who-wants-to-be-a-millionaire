package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private int difficultyLevel;
    private List<AbstractAnswer> answerList = new ArrayList<>();

    public Question(String question, int difficultyLevel, List<AbstractAnswer> answerList) {

        this.question = question;
        this.difficultyLevel = difficultyLevel;
        this.answerList = answerList;
    }

    public List<AbstractAnswer> getAnswerList() {
        return this.answerList;
    }


    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public String getQuestion() {
        return this.question;
    }

    public AbstractAnswer getCorrectAnswer() {
        for (AbstractAnswer answer : answerList) {
            if (answer.isCorrect()) {
                return answer;
            }
        }
        return null;
    }



    public int correctAnswerIndex(){
        for(AbstractAnswer answer:answerList){
            if(answer.isCorrect()){
                return answerList.indexOf(answer);
            }
        }
        return -1;
    }

}
