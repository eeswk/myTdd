package chap07.password;

public interface UserRepository {
    void save(User user);

    User findById(String id);
}
