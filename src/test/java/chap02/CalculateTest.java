package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {

    @Test
    void plus() {
        int result = Calculate.plus(1, 2);
        assertEquals(3, result);
        assertEquals(5, Calculate.plus(4,1));
    }
}
