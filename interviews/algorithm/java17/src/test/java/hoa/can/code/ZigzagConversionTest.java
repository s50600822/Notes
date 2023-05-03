package hoa.can.code;

import hoa.can.code.diff.ZigzagConversion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZigzagConversionTest {
    private ZigzagConversion converter = new ZigzagConversion();

    @Test
    @DisplayName("1 row")
    public void test2() {
        assertEquals(
                "PAYPALISHIRING",
                converter.convert("PAYPALISHIRING", 1)
        );
    }

    @Test
    @DisplayName("2 row")
    public void test3() {
        assertEquals(
                "PYAIHRNAPLSIIG",
                converter.convert("PAYPALISHIRING", 2)
        );
    }

    @Test    @DisplayName("3 row")
    public void test1() {
        assertEquals(
                "PAHNAPLSIIGYIR",
                converter.convert("PAYPALISHIRING", 3)
        );
    }


    @Test
    @DisplayName("ez debug")
    public void test4() {
        assertEquals(
                "0615724839",
                converter.convert("0123456789", 4)
        );
    }

}
