package ro.jademy.nicu;
import java.util.Objects;

public class Answer {
    private String answer;
    private boolean isCorrect;

    public Answer(String answer, boolean isCorrect) {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Answer(String answer) {
        this.answer = answer;
        this.isCorrect = false;
    }

    public String getAnswer() {
        return this.answer;
    }

    public boolean isCorrect() {
        return this.isCorrect;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return isCorrect == answer1.isCorrect && Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer, isCorrect);
    }
}
