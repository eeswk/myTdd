package chap09;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserGivenHelperTest {

    @Autowired
    private UserRegister register;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private UserGivenHelper given;

    @BeforeEach
    void setUp() {
        given = new UserGivenHelper(jdbcTemplate);
    }

    @Test
    void dupId() {
        given.givenUser("cbk","strongpw", "cbk@email.com");

        //실행, 결과확인
        assertThrows(DupIdException.class,
                () -> register.register("cbk","strongpw", "cbk@email.com"));
    }

    @Test
    void changeEmailTest() {
        given.givenUser("cbk","strongpw", "cbk1@email.com");

        given.changeEmail("cbk", "strongpw", "cbk2@email.com");

        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ? ", "cbk");
        rs.next();
        assertEquals("cbk2@email.com", rs.getString("email"));
    }


    @Test
    void 존재하지_않으면_저장함() {
        register.register("cbk2", "strongpw","cbk2@email.com");

        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ? ", "cbk2");
        rs.next();
        assertEquals("cbk2", rs.getString("id"));
    }

}
