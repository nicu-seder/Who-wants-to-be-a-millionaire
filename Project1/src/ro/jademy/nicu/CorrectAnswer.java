package ro.jademy.nicu;

public class CorrectAnswer extends AbstractAnswer {

    public CorrectAnswer(String answer) {
        super(answer);
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
