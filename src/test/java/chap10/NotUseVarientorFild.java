package chap10;

import chap09.DupIdException;
import chap09.User;
import chap09.UserRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class NotUseVarientorFild {

    @Test
    void dateFormat() {
        LocalDate date = LocalDate.of(1945, 8, 15);
        String dateStr = formateDate(date);
        assertEquals("1945년 8월 15일", dateStr);
    }

    private String formateDate(LocalDate date) {
        return date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() +"일";
    }

    private SurveyRepository surveyRepository;
    private MemoryRepository memoryRepository;
    private MemoryRespondentRepository respondentRepository;
    private SurveyServiceConvert svc;

    private List<Integer> answers = Arrays.asList(1, 2, 3, 4);
    private Long respondentId = 100L;

    @BeforeEach
    void setUp() {
        surveyRepository = new MemoryRepository(respondentRepository);
        respondentRepository  = new MemoryRespondentRepository();
        memoryRepository = new MemoryRepository(respondentRepository);
        svc = new SurveyServiceConvert(memoryRepository, respondentRepository);
    }


    @DisplayName("답변에 성공하면 결과 저장함.")
    @Test
    public void saveAnswerSuccessfully() {
        //답변할 설문이 존재
        Survey survey = SurveyFactory.createApprovedSuvery(1L);
        surveyRepository.save(survey);

        //설문 답변
        SurveyAnswerRequest suveyAnswer = SurveyAnswerRequest.builder()
                .suveryId(survey.getId())
                .respondentId(respondentId)
                .answers(answers)
                .build();

        svc.answerSuvey(suveyAnswer);

        //저장 결과 확인
        SurveyAnswer savedAnswer =
                memoryRepository.findBySuverAndRespondent(survey.getId(), respondentId);

        assertAll(
                () -> assertEquals(respondentId, savedAnswer.getRespondentId()),
                () -> assertEquals(answers.size(), savedAnswer.getAnswers().size()),
                () -> assertEquals(answers.get(0), savedAnswer.getAnswers().get(0)),
                () -> assertEquals(answers.get(1), savedAnswer.getAnswers().get(1)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(2)),
                () -> assertEquals(answers.get(2), savedAnswer.getAnswers().get(3))
        );
    }


    @DisplayName("답변에 성공하면 결과 저장함 수정버전")
    @Test
    public void saveAnswerSuccessfully_modify() {
        //답변할 설문이 존재
        Survey survey = SurveyFactory.createApprovedSuvery(1L);
        surveyRepository.save(survey);

        //설문 답변
        SurveyAnswerRequest suveyAnswer = SurveyAnswerRequest.builder()
                .suveryId(1L)
                .respondentId(100L)
                .answers(Arrays.asList(1,2,3,4))
                .build();

        svc.answerSuvey(suveyAnswer);

        //저장 결과 확인
        SurveyAnswer savedAnswer =
                memoryRepository.findBySuverAndRespondent(1L, 100L);

        assertAll(
                () -> assertEquals(100L, savedAnswer.getRespondentId()),
                () -> assertEquals(4, savedAnswer.getAnswers().size()),
                () -> assertEquals(1, savedAnswer.getAnswers().get(0)),
                () -> assertEquals(2, savedAnswer.getAnswers().get(1)),
                () -> assertEquals(3, savedAnswer.getAnswers().get(2)),
                () -> assertEquals(4, savedAnswer.getAnswers().get(3))
        );
    }
}

