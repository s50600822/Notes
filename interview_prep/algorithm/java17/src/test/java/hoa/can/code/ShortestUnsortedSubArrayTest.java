package hoa.can.code;
import static org.junit.jupiter.api.Assertions.assertEquals;
import hoa.can.code.ez.ShortestUnsortedSubArray;

import hoa.can.code.ez.ShortestUnsortedSubArray.*;
import org.junit.jupiter.api.Test;

public class ShortestUnsortedSubArrayTest {
    @Test
    public void test() {
        testSol(new ShortestUnsortedSubArray.SolA());
        //testSol(new ShortestUnsortedSubArray.SolB());
    }

    public void testSol(ShortestUnsortedSubArray.Sol solution){
        ShortestUnsortedSubArray t = new ShortestUnsortedSubArray(solution);
        assertEquals(
                0,
                t.findShortestUnorderedSubarray(new int[]{1, 2, 3, 4, 5})
        );                
        assertEquals(
                3,
                t.findShortestUnorderedSubarray(new int[]{7, 9, 10, 8, 11})
        );        
    }
}
