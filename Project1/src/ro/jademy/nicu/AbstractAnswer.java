package ro.jademy.nicu;

public abstract class AbstractAnswer {

    private String answer;


    public AbstractAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public abstract boolean isCorrect();
}
