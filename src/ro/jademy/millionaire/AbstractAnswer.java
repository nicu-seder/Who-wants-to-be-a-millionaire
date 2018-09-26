package ro.jademy.millionaire;

import java.util.Objects;

public abstract class AbstractAnswer {
    private String answer;

    public AbstractAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }

    public abstract boolean isCorrect();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnswer that = (AbstractAnswer) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }
}
