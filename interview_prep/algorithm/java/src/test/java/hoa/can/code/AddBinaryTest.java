package hoa.can.code;

import hoa.can.code.ez.AddBinary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddBinaryTest {
    AddBinary sol = new AddBinary();

    @Test
    @DisplayName("11 + 1 = 100")
    public void test1() {
        assertEquals("100", sol.addBinary("11","1"));
    }

    @Test
    @DisplayName("1 + 11 = 100")
    public void test2() {
        assertEquals("100", sol.addBinary("1","11"));
    }

    @Test
    @DisplayName("11 + 1 = 100")
    public void test3() {
        assertEquals("10101", sol.addBinary("1010","1011"));
    }
}
