package chap07.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterTest {
    private UserRegister userRegister;
    private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();
    private MemoryUserRepository fakeRepository = new MemoryUserRepository();

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(stubWeakPasswordChecker, fakeRepository);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        //암호가 약하다고 응답하도록 설정
        stubWeakPasswordChecker.setWeak(true);

        assertThrows(WeakPasswordException.class, () -> {
            userRegister.register("id", "pw", "email");
        });
    }

    @DisplayName("이미 같은 ID가 존재하면 회원 가입 실패")
    @Test
    void dupIdException() {
        fakeRepository.save(new User("id", "pw", "email@email.com"));

        assertThrows(DupIdException.class, () -> {
            userRegister.register("id", "pwd2", "email");
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
