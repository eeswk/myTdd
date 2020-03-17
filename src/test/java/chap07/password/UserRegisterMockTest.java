package chap07.password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserRegisterMockTest {
    private UserRegister userRegister;
    private WeakPasswordChecker mockPasswordChecker = Mockito.mock(WeakPasswordChecker.class);
    private UserRepository mockRepository = Mockito.mock(UserRepository.class);
    private EmailNotifier mockEmailNotifier = Mockito.mock(EmailNotifier.class);

    @BeforeEach
    void setUp() {
        userRegister = new UserRegister(mockPasswordChecker, mockRepository, mockEmailNotifier);
    }

    @DisplayName("약한 암호면 가입 실패")
    @Test
    void weakPassword() {
        BDDMockito.given(mockPasswordChecker.checkerPasswordWeak("pw")).willReturn(true);
        assertThrows(WeakPasswordException.class, ()->{
           userRegister.register("id", "pw","email");
        });

    }

    @DisplayName("회원가입시 암호 검사 수행함")
    @Test
    void checkPassword() {
        userRegister.register("id", "pw","email");

        BDDMockito.then(mockPasswordChecker)
                .should()
                .checkerPasswordWeak(BDDMockito.anyString());
    }

    @DisplayName("가입하면 메일을 전송함.")
    @Test
    void whenRegisterThenSendMail() {
        userRegister.register("id","pw","email@email.com");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        BDDMockito.then(mockEmailNotifier)
                .should().sendRegisterEmail(captor.capture());

        String realEmail = captor.getValue();
        assertEquals("email@email.com", realEmail);
    }

    //결과검증을 모의객체로 할경우 테스트코드가 복잡해진다.
    //결과검증은 가짜 메모리 객체를 이용해서 하면 단순해진다.
    //UserRegisterTest의 DupId_RegisterSuccess 메서드 참조.
    @DisplayName("존재 하지 않는 ID 경우 가입 성공")
    @Test
    void noDupId_RegisterSuccess() {
        userRegister.register("id","pw", "email");

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        BDDMockito.then(mockRepository).should().save(captor.capture());

        User savedUser = captor.getValue();
        assertEquals("id", savedUser.getId());
        assertEquals("email", savedUser.getEmail());
    }
}
