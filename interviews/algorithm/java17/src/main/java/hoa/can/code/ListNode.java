package hoa.can.code;

import java.util.Objects;

public class ListNode {
    // shut up let me focus on reverting linked list
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
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