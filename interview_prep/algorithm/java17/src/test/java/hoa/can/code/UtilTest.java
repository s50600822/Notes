package hoa.can.code;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    @DisplayName("get array tail")
    public void test(){
        int[] subArr = util.Array.tail(new int[]{1,2,3,4,5});
        assertArrayEquals(
                new int[]{2,3,4,5},
                subArr
        );

        int[] subArrEmpty = util.Array.tail(new int[]{1});
        assertEquals(0, subArrEmpty.length);

        int[] subArrEmpty2 = util.Array.tail(new int[]{});
        assertEquals(0, subArrEmpty2.length);
    }
}
