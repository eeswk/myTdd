package chap10;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class SurveyServiceConvert {

    private SurveyRepository surveyRepository;
    private RespondentRepository respondentRepository;

    public SurveyServiceConvert(SurveyRepository surveyRepository, RespondentRepository respondentRepository) {
        this.surveyRepository = surveyRepository;
        this.respondentRepository = respondentRepository;
    }

    public void answerSuvey(SurveyAnswerRequest surveyAnswer) {
        Survey survey = new Survey(surveyAnswer.getSuveryId());

        List<Integer> answers = surveyAnswer.getAnswers();
        //List<Answer> collect = answers.stream().map(Answer::new).collect(Collectors.toList());
        //System.out.println(collect);
        Respondent respondent = new Respondent(surveyAnswer.getRespondentId(), answers);
        surveyRepository.save(survey);
        respondentRepository.save(respondent);


    }
}
