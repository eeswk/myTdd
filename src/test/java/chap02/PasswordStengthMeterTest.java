package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStengthMeterTest {

    private PasswordStengthMeter meter = new PasswordStengthMeter();

    @Test
    void meetsAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStength.STRONG);
        assertStrength("abc1!Add", PasswordStength.STRONG);
    }

    @Test
    void meetsOtherCriteria_exception_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStength.NORMAL);
    }

    @Test
    void meetOtherCriteria_exception_for_number_Then_Noraml() {
        assertStrength("ab!@ABqwr", PasswordStength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null, PasswordStength.INVALID);
    }

    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("", PasswordStength.INVALID);
    }

    @Test
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df", PasswordStength.NORMAL);
    }

    @Test
    void meetOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStength.WEAK);
    }

    private void assertStrength(String password, PasswordStength expStr) {
        PasswordStength result = meter.meter(password);
        assertEquals(expStr, result);
    }
}
