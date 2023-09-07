package hoa.can.code;
import hoa.can.code.ez.Fib;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibTest {
    @Test
    @DisplayName("f(6)=5")
    public void test6() {
        // prob should start at 1 - f(1)=1 instead?
        assertEquals(0,new Fib().fib(1));
        assertEquals(1,new Fib().fib(2));
        assertEquals(1,new Fib().fib(3));
        assertEquals(2,new Fib().fib(4));
        assertEquals(3,new Fib().fib(5));
        assertEquals(5,new Fib().fib(6));
    }
}
