package ro.jademy.millionaire;

import java.util.Objects;

public class Answer {
    private String answer;
    public boolean correct;

    public Answer(String answer, boolean correct){
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer1 = (Answer) o;
        return correct == answer1.correct &&
                Objects.equals(answer, answer1.answer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(answer, correct);
    }
}
