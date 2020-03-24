package chap10;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository{
    private Map<String, User> data = new HashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return data.get(id);
    }


}
