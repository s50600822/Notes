
class Solution {
    static final String ODD = "Odd";
    static final String EVEN = "Even";
    static final String TIE = "Tie";
    public String gameResult(ListNode head) {
        int odd = 0, even = 0;
        for (; head != null; head = head.next.next) {
            int a = head.val;
            int b = head.next.val;
            odd += a < b ? 1 : 0;
            even += a > b ? 1 : 0;
        }
        if (odd > even) {
            return ODD;
        }
        if (odd < even) {
            return EVEN;
        }
        return TIE;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        // Paywall, pretty cunty in bird culture.
        // https://leetcode.com/problems/winner-of-the-linked-list-game/description/
        Solution solution = new Solution();
        ListNode head1 = null;
        System.out.println("Test Case 1: " + solution.gameResult(head1)); // Expected output: "Draw"
        assert solution.gameResult(head1).equals(TIE);


        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(1);
        System.out.println("Test Case 2: " + solution.gameResult(head2)); // Expected output: "Draw"
        assert solution.gameResult(head2).equals(TIE);


        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        System.out.println("Test Case 3: " + solution.gameResult(head3));
        assert solution.gameResult(head3).equals(ODD);

        ListNode head3b = new ListNode(2);
        head3b.next = new ListNode(1);
        System.out.println("Test Case 3b: " + solution.gameResult(head3b));
        assert solution.gameResult(head3b).equals(EVEN);

        // Test Case 4: Linked list with three nodes
        ListNode head4 = new ListNode(2);
        head4.next = new ListNode(5);
        head4.next.next = new ListNode(4);
        head4.next.next.next = new ListNode(7);
        head4.next.next.next.next = new ListNode(20);
        head4.next.next.next.next.next = new ListNode(5);
        System.out.println("Test Case 4: " + solution.gameResult(head4));
        assert solution.gameResult(head4).equals(ODD);



    }
}