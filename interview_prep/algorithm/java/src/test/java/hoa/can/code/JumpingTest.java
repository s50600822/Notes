package hoa.can.code;

import hoa.can.code.gg.Jumping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class JumpingTest {
    public JumpingTest(Jumping algo) {
        this.algo = algo;
    }

    Jumping algo;

    @Test
    @DisplayName("SHOULD BE ABLE to jump")
    public void shouldBeAbleTo() {
        //canJump(new int[]{0});// depends
        canJump(new int[]{2, 3, 1, 1, 4});
        canJump(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9});
        canJump(new int[]{3, 2, 1, 1, 1, 2, 3, 4, 5, 1, 3, 0, 2, 3, 0, 3, 1, 2, 3, 9, 1, 0, 0, 4, 1, 1, 1, 0, 2, 3, 4, 0, 9, 0, 0, 1, 2, 3, 9, 0, 0, 1, 0, 0, 1, 0, 1, 2, 3, 4});
    }

    @Test
    @DisplayName("SHOULD NOT be able to jump")
    public void shouldNOTBeAbleTo() {
        canNotJump(new int[]{0, 1});
        canNotJump(new int[]{3, 2, 1, 0, 4});
        canNotJump(new int[]{2, 0, 0, 0, 3});
        canNotJump(new int[]{4, 3, 2, 1, 0, 0, 0});
        canNotJump(new int[]{3, 2, 1, 0, 1, 2, 3, 4, 5, 1, 0, 0, 2, 3, 0, 0, 1, 2, 3, 0, 1, 0, 0, 4, 1, 1, 1, 0, 2, 3, 4, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 1, 0, 0, 1, 0, 1, 2, 3, 4});
    }

    @Test
    @DisplayName("Verify steps COUNT")
    public void verifyMinStepCount() {
        yesWithDetail(new int[]{1, 2}, 1, "1 -> end");
        yesWithDetail(new int[]{2, 0, 1}, 1, "2 -> end");
        yesWithDetail(new int[]{2, 3, 1, 1, 4}, 2, "2 -> 3 -> end");
        yesWithDetail(new int[]{10, 8, 12, 17, 1, 21, 5, 17, 20, 11, 5, 27, 23, 8, 12, 18, 16, 12, 9, 8, 17, 12, 23, 26, 0, 5, 9, 24, 10}, 2, "10 -> 20 -> end");
        yesWithDetail(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}, 3, "5->9->3->end");
        yesWithDetail(new int[]{1, 1, 1, 1, 1, 1}, 5, "1 -> 1 ->... end");
    }

    @Test
    @DisplayName("Verify work on considerable length")
    public void slow() {
        assertEquals(
                13,
                algo.minJumps(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}),
                "quick"
        );
        assertEquals(
                13,
                algo.minJumps(new int[]{8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5}),
                "quick"
        );
    }

    void canJump(int[] steps) {
        String log = format("%s Should be REACHABLE", Arrays.toString(steps));
        assertTrue(algo.canJump(steps), log);
    }

    void canNotJump(int[] steps) {
        assertFalse(algo.canJump(steps));
    }

    void yesWithDetail(int[] steps, int expected, String msg) {
        String log = format("\n%s \n%s", Arrays.toString(steps), msg);
        assertEquals(expected, algo.minJumps(steps), log);
    }
}
