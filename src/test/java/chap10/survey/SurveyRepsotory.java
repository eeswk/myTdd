package chap10.survey;

import org.springframework.data.repository.Repository;

public interface SurveyRepsotory extends Repository<Survey, Long> {

    void save(Survey survey);

}
