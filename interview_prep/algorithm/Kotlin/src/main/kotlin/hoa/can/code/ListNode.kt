package hoa.can.code

//data class ListNode (var value: Int, var next: ListNode)
class ListNode(var value: Int) {
    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ListNode) return false

        return value == other.value && next == other.next
    }

    override fun hashCode(): Int {
        var result = value
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }
}
