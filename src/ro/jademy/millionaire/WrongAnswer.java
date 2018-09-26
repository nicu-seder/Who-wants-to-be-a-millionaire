package ro.jademy.millionaire;

public class WrongAnswer extends AbstractAnswer {
    public WrongAnswer(String answer) {
        super(answer);
    }

    @Override
    public boolean isCorrect() {
        return true;
    }
}
