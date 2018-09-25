package ro.jademy.nicu;

public class WrongAnswer extends AbstractAnswer {

    public WrongAnswer(String answer){
        super(answer);
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
}
