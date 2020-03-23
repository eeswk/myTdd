package chap10;

import java.util.List;

public class Respondent {
    private Long id;
    private List<Integer> answers;

    public Respondent(Long id, List<Integer> answers) {
        this.id = id;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getAnswers() {
        return answers;
    }
}
