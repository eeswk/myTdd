package chap10.survey;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.util.Arrays.asList;

public class SurveyTest {
    private MemorySurveyReposotry memorySurveyRepostiroy = new MemorySurveyReposotry();

    @Test
    void answer() {
        /*
        memorySurveyRepostiroy.save(
                Survey.builder().id(1L)
                    .status(SurveyStatus.OPEN)
                    .endOfPeriod(LocalDateTime.now().plusDays(5))
                    .questions(asList(
                            new Question(1,"질문",
                                    asList(Item.of(1, "보기1")
                                        ,Item.of(2,"보기2"))),
                            new Question(1, "질문2",
                                    asList(Item.of(1," 답1"),
                                            Item.of(2,"답2")))
                    )).build()

        );
         */
        memorySurveyRepostiroy.save(SurveyFactory.createAnswerableSurvery(1L));

        //answerService.ansewer();

    }
}
