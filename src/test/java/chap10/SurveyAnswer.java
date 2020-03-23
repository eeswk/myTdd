package chap10;

import java.util.List;

public class SurveyAnswer {
    private Survey survey;
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswer(Survey survey, Long respondentId, List<Integer> answers) {
        this.survey = survey;
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public Long getRespondentId() {
        return respondentId;
    }
}
