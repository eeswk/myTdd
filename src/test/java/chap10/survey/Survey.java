package chap10.survey;

import java.time.LocalDateTime;
import java.util.List;

public class Survey {
    private Long id;
    private String title;
    private SurveyStatus status;
    private LocalDateTime endOfPeriod;
    private List<Question> questions;

    public Survey() {
    }


    public Long getId() {
        return id;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Survey data = new Survey();

        public Builder id(Long id) {
            data.id = id;
            return this;
        }

        public Builder title(String title) {
            data.title = title;
            return this;
        }

        public Builder status(SurveyStatus status) {
            data.status = status;
            return this;
        }

        public Builder endOfPeriod(LocalDateTime time) {
            data.endOfPeriod = time;
            return this;
        }

        public Builder questions(List<Question> list) {
            data.questions = list;
            return this;
        }

        public Survey build() {
            return data;
        }

    }


}
