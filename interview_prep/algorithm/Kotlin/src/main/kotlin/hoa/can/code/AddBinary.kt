package hoa.can.code

/**
 * https://leetcode.com/problems/add-binary/
 */
class AddBinary {
    fun addBinary(a: String, b: String): String {
        val result = StringBuilder()
        var carry = 0
        var i = a.length - 1
        var j = b.length - 1
        while (i >= 0 || j >= 0 || carry > 0) {
            var sum = carry
            if (i >= 0) {
                sum += a[i].code - '0'.code
                i--
            }
            if (j >= 0) {
                sum += b[j].code - '0'.code
                j--
            }
            carry = sum / 2
            result.insert(0, sum % 2)
        }
        return result.toString()
    }
}