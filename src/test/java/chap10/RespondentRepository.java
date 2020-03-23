package chap10;

import org.springframework.data.repository.Repository;

public interface RespondentRepository extends Repository<Respondent, Long> {
    void save(Respondent respondent);

    Respondent getById(Long id);
}
