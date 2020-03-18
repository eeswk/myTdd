package chap09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterUnitTest {

    private UserRegister userRegister;
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    private SimpleWeakPasswordChecker passwordChecker = new SimpleWeakPasswordChecker();
    private VirtualEmailNotifier emailNotifier = new VirtualEmailNotifier();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(passwordChecker, fakeRepository, emailNotifier);
    }


    @DisplayName("이미 같은 ID가 존재하면 회원 가입 실패")
    @Test
    void dupIdException() {
        fakeRepository.save(new User("id", "strongpw", "email@email.com"));

        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "strongpw", "email");
        });
    }

    @DisplayName("존재 하지 않는 ID 경우 가입 성공")
    @Test
    void noDupId_RegisterSuccess() {
        userRegister.register("id","pw", "email");

        User savedUser = fakeRepository.findById("id");
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }


}
