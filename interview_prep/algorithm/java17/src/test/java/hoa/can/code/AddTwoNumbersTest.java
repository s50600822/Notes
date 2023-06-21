package hoa.can.code;

import hoa.can.code.ez.AddTwoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AddTwoNumbersTest {
    AddTwoNumbers sol = new AddTwoNumbers();

    @Test
    @DisplayName("1+2=3")
    public void test1() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        assertEquals(
                new ListNode(3),
                sol.addTwoNumbers(n1, n2)
        );
    }

    @Test
    @DisplayName("10+20=30")
    public void test2() {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(0);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(0);

        ListNode r = new ListNode(3);
        r.next = new ListNode(0);
        assertEquals(
                r,
                sol.addTwoNumbers(n1, n2)
        );
    }

    @Test
    @DisplayName("99+88=187")
    public void test3() {
        ListNode n1 = new ListNode(9);
        n1.next = new ListNode(9);
        ListNode n2 = new ListNode(8);
        n2.next = new ListNode(8);

        ListNode r = new ListNode(7);
        r.next = new ListNode(8);
        r.next.next = new ListNode(1);
        assertEquals(
                r,
                sol.addTwoNumbers(n1, n2)
        );
    }


    @Test
    @DisplayName("243+564=708")
    public void test4() {
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode r = new ListNode(7);
        r.next = new ListNode(0);
        r.next.next = new ListNode(8);
        assertEquals(
                r,
                sol.addTwoNumbers(n1, n2)
        );
    }
}
