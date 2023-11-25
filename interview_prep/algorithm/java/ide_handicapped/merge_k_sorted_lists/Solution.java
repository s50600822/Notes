import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    /**
     * t: O(nlogk)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> compartor = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };

        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(compartor);

        for (ListNode head : lists) {
            if (head != null) {
                pQueue.add(head);
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!pQueue.isEmpty()) {
            ListNode tmp = pQueue.poll();
            cur.next = tmp;
            cur = tmp;
            if (cur.next != null) {
                pQueue.add(cur.next);
            }
        }
        return head.next;
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
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ListNode{");
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append(" -> ");
                }
                current = current.next;
            }
            sb.append("}");
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ListNode other = (ListNode) obj;
            ListNode currentThis = this;
            ListNode currentOther = other;

            while (currentThis != null && currentOther != null) {
                if (currentThis.val != currentOther.val) {
                    return false;
                }
                currentThis = currentThis.next;
                currentOther = currentOther.next;
            }
            return currentThis == null && currentOther == null;
        }
    }

    public static ListNode listNode(int... values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution self = new Solution();
        assert listNode(1, 1, 2, 3, 4, 4, 5, 6).equals(
                self.mergeKLists(
                        new ListNode[] {
                                listNode(1, 4, 5),
                                listNode(1, 3, 4),
                                listNode(2, 6)
                        }));
    }
}