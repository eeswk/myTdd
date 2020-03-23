package chap10;

import org.springframework.data.repository.Repository;

public interface SurveyRepository extends Repository<Survey, Long> {
    void save(Survey survey);

    Survey findById(Long id);
}
