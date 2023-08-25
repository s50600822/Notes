package hoa.can.code;


import hoa.can.code.ez.AppleAndOrange;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class AppleAndOrangeTest {
    @Test
    @DisplayName("https://www.hackerrank.com/challenges/apple-and-orange/problem")
    public void test() {
        // NOT REALLY :)))
        AppleAndOrange.countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
        assertEquals(1,AppleAndOrange.countF(7, 11, 5, List.of(-2, 2, 1)));
        assertEquals(1,AppleAndOrange.countF(7, 11, 15, List.of(5, -6)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 5, 15, List.of(2, 3, -4, 12), List.of(17, -5, -1, 6));
        assertEquals(2, AppleAndOrange.countF(7, 11, 5, List.of(2, 3, -4, 12)));
        assertEquals(1, AppleAndOrange.countF(7, 11, 15, List.of(17, -5, -1, 6)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 12, 15, List.of(13, 14, 16, 18), List.of(17, 19, 20, 21));
        assertEquals(0, AppleAndOrange.countF(7, 11, 12, List.of(13, 14, 16, 18)));
        assertEquals(0, AppleAndOrange.countF(7, 11, 15, List.of(17, 19, 20, 21)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 7, 11, List.of(0, 0, 0, 0), List.of(0, 0, 0, 0));
        assertEquals(4, AppleAndOrange.countF(7, 11, 7, List.of(0, 0, 0, 0)));
        assertEquals(4, AppleAndOrange.countF(7, 11, 11, List.of(0, 0, 0, 0)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 6, 11, List.of(1, 2, 3, 4), List.of(0, 1, 2, 3));
        assertEquals(4, AppleAndOrange.countF(7, 11, 6, List.of(1, 2, 3, 4)));
        assertEquals(1, AppleAndOrange.countF(7, 11, 11, List.of(0, 1, 2, 3)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 5, 15, List.of(), List.of());
        assertEquals(0, AppleAndOrange.countF(7, 11, 5, List.of()));
        assertEquals(0, AppleAndOrange.countF(7, 11, 15, List.of()));
        
        AppleAndOrange.countApplesAndOranges(-5, 5, 0, 0, List.of(-1, -2, -3, -4), List.of(-1, -2, -3, -4));
        assertEquals(4, AppleAndOrange.countF(-5, 5, 0, List.of(-1, -2, -3, -4)));
        assertEquals(4, AppleAndOrange.countF(-5, 5, 0, List.of(-1, -2, -3, -4)));
        
        AppleAndOrange.countApplesAndOranges(7, 11, 2, 18, List.of(-10, -5, 20, 25), List.of(-15, 15, 30, 35));
        assertEquals(0, AppleAndOrange.countF(7, 11, 2, List.of(-10, -5, 20, 25)));
        assertEquals(0, AppleAndOrange.countF(7, 11, 18, List.of(-15, 15, 30, 35)));
        
    }

}

