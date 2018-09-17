package ro.jademy.millionaire;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public static final int MAX_LEVEL = 15;

    private String question;
    private int difficultyLevel;
    private List<Answer> answerList = new ArrayList<>();


    public Question(String question, int difficultyLevel,List<Answer> listOfAnswers){
        this.question = question;
        this.difficultyLevel = difficultyLevel;
        answerList.addAll(listOfAnswers);
    }

    /**
     *
      * @return it returns the correct answer for the specified question
     */
   public Answer getCorrectAnswer(){
        for(Answer answer:answerList){
            if(answer.correct){
                return answer;
            }
        }
        return null;
   }

   public void showAnswers(){
       for(int i = 0;i < answerList.size();i++){
           System.out.println("   " + (i+1) +"."+answerList.get(i).getAnswer());
       }
   }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
