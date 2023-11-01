package hoa.can.code

//https://leetcode.com/problems/add-two-numbers/description/

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        return addTwoNumbers(l1, l2, 0)
    }
    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carriedOver: Int): ListNode {
        var carriedOver = carriedOver
        var val1 = 0
        var val2 = 0
        if (l1 != null) {
            val1 = l1.value
        }
        if (l2 != null) {
            val2 = l2.value
        }
        val current = (val1 + val2 + carriedOver) % 10
        carriedOver = (val1 + val2 + carriedOver) / 10
        val currentN = ListNode(current)
        if (next(l1) != null || next(l2) != null || carriedOver > 0) {
            currentN.next = addTwoNumbers(next(l1), next(l2), carriedOver)
        }
        return currentN
    }

    private fun next(current: ListNode?): ListNode? {
        return current?.next
    }
}