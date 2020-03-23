package chap10;

import java.util.List;

public class SurveyAnswerRequest {

    private Long suveryId;
    private Long respondentId;
    private List<Integer> answers;

    public SurveyAnswerRequest(Long suveryId, Long respondentId, List answers) {
        this.suveryId = suveryId;
        this.respondentId = respondentId;
        this.answers = answers;
    }

    public SurveyAnswerRequest() {
    }

    public Long getSuveryId() {
        return suveryId;
    }

    public Long getRespondentId() {
        return respondentId;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SurveyAnswerRequest data = new SurveyAnswerRequest();

        public Builder suveryId(Long suveryId) {
            data.suveryId = suveryId;
            return this;
        }

        public Builder respondentId(Long respondentId) {
            data.respondentId = respondentId;
            return this;
        }

        public Builder answers(List<Integer> answers) {
            data.answers = answers;
            return this;
        }

        public SurveyAnswerRequest build() {
            return data;
        }

    }


}
