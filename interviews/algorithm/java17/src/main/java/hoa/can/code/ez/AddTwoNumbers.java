package hoa.can.code.ez;

import java.util.Objects;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
    public ListNode solve(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, int carriedOver) {
        int val1 = 0;
        int val2 = 0;
        if (l1 != null) {
            val1 = l1.val;
        }
        if (l2 != null) {
            val2 = l2.val;
        }
        int current = (val1 + val2 + carriedOver) % 10;
        carriedOver = (val1 + val2 + carriedOver) / 10;

        ListNode currentN = new ListNode(current);

        if (next(l1) != null || next(l2) != null || carriedOver > 0) {
            currentN.next = addTwoNumbers(next(l1), next(l2), carriedOver);
        }
        return currentN;
    }

    private ListNode next(ListNode current) {
        if (current != null) {
            return current.next;
        }
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (!(obj instanceof ListNode)) {
                return false;
            }

            ListNode other = (ListNode) obj;
            return this.val == other.val && Objects.equals(this.next, other.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.val, this.next);
        }
    }
}
