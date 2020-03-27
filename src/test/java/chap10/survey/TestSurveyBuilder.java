package chap10.survey;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

public class TestSurveyBuilder {
    private Long id = 1L;
    private String tittle = "제목";
    private LocalDateTime endOfPeriod = LocalDateTime.now().plusDays(5);
    private List<Question> questions = asList(
            new Question(1,"질문1",
                    asList(Item.of(1,"보기1"), Item.of(2,"보기2"))),
            new Question(1, "질문2",
                    asList(Item.of(1, "답1"), Item.of(2,"답2")))
            );
    private SurveyStatus status = SurveyStatus.READY;

    public TestSurveyBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public TestSurveyBuilder title(String title) {
        this.tittle = title;
        return this;
    }

    public TestSurveyBuilder open() {
        this.status = SurveyStatus.OPEN;
        return this;
    }

    public TestSurveyBuilder endOfPeriod() {
        this.endOfPeriod = LocalDateTime.now().plusDays(5);
        return this;
    }

    public TestSurveyBuilder questions(List questions) {
        this.questions = questions;
        return this;
    }

    public Survey build() {
        return Survey.builder()
                .id(id).title(tittle).status(status)
                .endOfPeriod(endOfPeriod)
                .questions(questions)
                .build();
    }
}
