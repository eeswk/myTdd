package chap10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChangeServiceTest {
    private ChangeUserService changeService;
    private MemoryUserRepository memoryRepository = new MemoryUserRepository();


    @BeforeEach
    void setUp() {
        changeService = new ChangeUserService(memoryRepository);

        //memoryRepository.save(new User("id", "pwd", new Address("서울", "북부")));
    }

    @Test
    void noUser() {
        assertThrows(
                UserNotFoundException.class,
                () -> changeService.changeAddress("id2", new Address("서울", "남부"))
        );
    }

    @Test
    void changeAddress() {
        memoryRepository.save(new User("id", "pwd", new Address("서울", "북부")));

        changeService.changeAddress("id", new Address("서울", "남부"));
        User user = memoryRepository.findById("id");
        assertEquals("남부", user.getAddress().getLocation());
    }

    @Test
    void changePw() {
        memoryRepository.save(new User("id", "pwd", new Address("서울", "북부")));
        changeService.changePw("id", "pwd", "newpw");

        User user = memoryRepository.findById("id");
        assertTrue(user.matchPassword("newpw"));
    }

    @Test
    void pwNotMatch() {
        memoryRepository.save(new User("id", "pwd", new Address("서울", "북부")));

        assertThrows(
                IdPwNotMatchException.class,
                () -> changeService.changePw("id", "pw2", "newpw")
        );
    }

}
