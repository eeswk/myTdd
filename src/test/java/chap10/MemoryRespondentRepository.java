package chap10;

import java.util.HashMap;
import java.util.Map;

public class MemoryRespondentRepository implements RespondentRepository {
    private Map<Long, Respondent> data = new HashMap<>();
    @Override
    public void save(Respondent respondent) {
        data.put(respondent.getId(), respondent);
    }

    public Respondent getById(Long respondentId) {
        return data.get(respondentId);
    }
}
