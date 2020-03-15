package chap07;

import java.util.HashMap;
import java.util.Map;

public class MemoryAutoDebitRepository implements AutoDebitInfoRepository {
    private Map<String, AutoDebitInfo> infos = new HashMap<>();
    @Override
    public AutoDebitInfo findOne(String userId) {
        return infos.get(userId);
    }

    @Override
    public void save(AutoDebitInfo info) {
        infos.put(info.getUsrId(), info);
    }
}
