package chap09;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserGivenHelper {
    private JdbcTemplate jdbcTemplate;

    public UserGivenHelper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void givenUser(String id, String pw, String email) {
        jdbcTemplate.update(
                "insert into user (id, password, email) values(?, ?, ?)",
                id, pw, email
        );
    }

    public void changeEmail(String id, String pw, String email) {
        User user = selectUser(id, pw, email);

        if (user == null) {
            throw new NoUserExepction();
        }
        jdbcTemplate.update(
                "update user set email = ? where id = ?"
                , email, id);
    }

    private User selectUser(String id, String pw, String email) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from user where id = ? ", id);
        rs.next();
        String rsId = rs.getString("id");
        String rsPw = rs.getString("password");
        String rsEmail = rs.getString("email");
        User user = new User(rsId, rsPw, rsEmail);
        return user;
    }


}
