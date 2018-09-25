package ro.jademy.nicu;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private int difficultyLevel;
    private List<Answer> answerList = new ArrayList<>();

    public Question(String question, int difficultyLevel, List<Answer> answerList) {
        this.question = question;
        this.difficultyLevel = difficultyLevel;
        this.answerList = answerList;
    }

    public List<Answer> getAnswerList() {
        return this.answerList;
    }

    public int getDifficultyLevel() {
        return this.difficultyLevel;
    }

    public String getQuestion() {
        return this.question;
    }


    public Answer getCorrectAnswer() {
        for (Answer answer : answerList) {
            if (answer.isCorrect()) {
                return answer;
            }
        }
        return null;
    }

    public int correctAnswerIndex(){
        for(Answer answer:answerList){
            if(answer.isCorrect()){
                return answerList.indexOf(answer);
            }
        }
        return -1;
    }
}
