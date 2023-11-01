package hoa.can.code

class Sqrt {
    fun sqrt(x: Int): Int {
        if (x == 0 || x == 1) {
            return x
        }
        var left: Long = 1
        var right = x.toLong()
        var result: Long = 0
        while (left <= right) {
            val mid = left + (right - left) / 2
            val square = mid * mid
            if (square == x.toLong()) {
                return mid.toInt()
            } else if (square < x) {
                left = mid + 1
                result = mid
            } else {
                right = mid - 1
            }
        }
        return result.toInt()
    }
}