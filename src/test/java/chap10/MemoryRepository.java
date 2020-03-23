package chap10;

import chap09.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryRepository implements SurveyRepository {
    private Map<Long, Survey> surveyMap = new HashMap<>();
    private MemoryRespondentRepository respondentRepository;

    public MemoryRepository(MemoryRespondentRepository respondentRepository) {
        this.respondentRepository = respondentRepository;
    }

    public SurveyAnswer findBySuverAndRespondent(Long suveyId, Long respondentId) {
        Survey suvey = surveyMap.get(suveyId);
        Respondent respondent = respondentRepository.getById(respondentId);
        return new SurveyAnswer(suvey, respondent.getId(), respondent.getAnswers());
    }

    @Override
    public void save(Survey survey) {
        surveyMap.put(survey.getId(), survey);
    }

    public Survey findById(Long id) {
        return surveyMap.get(id);
    }

}
