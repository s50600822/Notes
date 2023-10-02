package hoa.can.code;

import hoa.can.code.ez.BirthdayBar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BirthdayBarTest {
    @Test
    @DisplayName("https://www.hackerrank.com/challenges/the-birthday-bar/problem")
    public void test1() {

        assertEquals(0, BirthdayBar.birthday(List.of(1, 1, 1, 1, 1, 1), 3, 2));
        assertEquals(2, BirthdayBar.birthday(List.of(1, 2, 1, 3, 2), 3, 2));
        assertEquals(1, BirthdayBar.birthday(List.of(4), 4, 1));
    }
}
