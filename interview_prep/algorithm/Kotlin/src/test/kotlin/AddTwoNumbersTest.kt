import hoa.can.code.AddTwoNumbers
import hoa.can.code.ListNode
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

class AddTwoNumbersTest {
    class AddTwoNumbersTest {
        var sol = AddTwoNumbers()

        @Test
        fun test1() {
            val n1 = ListNode(1)
            val n2 = ListNode(2)
            assertEquals(
                "1+2=3",
                ListNode(3),
                sol.addTwoNumbers(n1, n2)
            )
        }

        @Test
        fun test2() {
            val n1 = ListNode(1)
            n1.next = ListNode(0)
            val n2 = ListNode(2)
            n2.next = ListNode(0)
            val r = ListNode(3)
            r.next = ListNode(0)
            assertEquals(
                "10+20=30",
                r,
                sol.addTwoNumbers(n1, n2)
            )
        }

        @Test
        fun test3() {
            val n1 = ListNode(9)
            n1.next = ListNode(9)
            val n2 = ListNode(8)
            n2.next = ListNode(8)
            val r = ListNode(7)
            r.next = ListNode(8)
            r.next!!.next = ListNode(1)
            assertEquals(
                "99+88=187",
                r,
                sol.addTwoNumbers(n1, n2)
            )
        }

        @Test
        fun test4() {
            val n1 = ListNode(2)
            n1.next = ListNode(4)
            n1.next!!.next = ListNode(3)
            val n2 = ListNode(5)
            n2.next = ListNode(6)
            n2.next!!.next = ListNode(4)
            val r = ListNode(7)
            r.next = ListNode(0)
            r.next!!.next = ListNode(8)

            assertEquals(
                "243+564=708",
                r,
                sol.addTwoNumbers(n1, n2)
            )
        }
    }

}