package chap10;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemberTest {

    @Test
    void notExpried() {
        LocalDateTime expired = LocalDateTime.of(2020,4, 1, 0, 0 ,0 );
        Member member = Member.builder().expiryDate(expired).build();
        assertFalse(member.isExpried());
    }

    @Test
    void notExpired() {
        LocalDateTime expiry = LocalDateTime.of(2020, 4, 1, 0, 0, 0);
        Member member = Member.builder().expiryDate(expiry).build();
        assertFalse(member.passedExpiredDate(LocalDateTime.of(2020, 3, 31, 0, 0, 0)));
    }

    @Test
    void expired_Only_1ms() {
        LocalDateTime expiry = LocalDateTime.of(2020, 4, 1, 0, 0, 0);
        Member member = Member.builder().expiryDate(expiry).build();
        assertTrue(member.passedExpiredDate(LocalDateTime.of(2020, 4, 1, 0, 0, 0, 1000000)));
    }
}
