package chap10.survey;

import java.util.HashMap;
import java.util.Map;

public class MemorySurveyReposotry implements SurveyRepsotory {
    private Map<Long, Survey> data = new HashMap<>();

    @Override
    public void save(Survey survey) {
        data.put(survey.getId(), survey);
    }
}
