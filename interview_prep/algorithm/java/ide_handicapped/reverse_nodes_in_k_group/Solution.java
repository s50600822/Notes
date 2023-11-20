class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
    ListNode current = head;
    int count = 0;

    while (current != null && count != k) {
        current = current.next;
        count++;
    }

    if (count == k) {
        current = reverseKGroup(current, k);
        while (count-- > 0) {
            ListNode tmp = head.next;
            head.next = current;
            current = head;
            head = tmp;
        }
        head = current;
    }

    return head;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rev = reverseKGroup(head, 2);

        assert rev.val == 2;
        assert rev.next.val == 1;
        assert rev.next.next.val == 4;
        assert rev.next.next.next.val == 3;
        assert rev.next.next.next.next.val == 5;
    }
}