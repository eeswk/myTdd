package chap09;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String> {
    void save(User user);

    User findById(String id);
}
