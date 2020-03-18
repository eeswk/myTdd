package chap09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class UserRegisterTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRegister userRegister;

    @Test
    void 동일ID가_이미_존재하면_익셉션() {
        jdbcTemplate.update(
                "INSERT INTO USER VALUES (?,?,?)",
                "cbk","pw","cbk@cbk.com");

        assertThrows(DupIdException.class, () -> {
            userRegister.register("cbk","strongpw","cbk@cbk.com");
        });

    }

    @Test
    void 존재하지_않는면_저장함() {
        jdbcTemplate.update("DELETE FROM USER WHERE ID = ? ", "cbk");

        userRegister.register("cbk","strongpw", "cbk@cbk.com");

        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ? ", "cbk");
        rs.next();
        assertEquals("cbk@cbk.com", rs.getString("email"));
    }



}
