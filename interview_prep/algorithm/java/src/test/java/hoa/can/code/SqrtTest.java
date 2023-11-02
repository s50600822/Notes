package hoa.can.code;

import hoa.can.code.ez.Sqrt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqrtTest {
    Sqrt sol = new Sqrt();

    @Test
    public void test    () {
        assertEquals(1, sol.sqrt(1));
        assertEquals(2, sol.sqrt(4));
        assertEquals(3, sol.sqrt(9));
    }
}
