import hoa.can.code.Sqrt
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

internal class SqrtTest {
    private val tc: Sqrt = Sqrt()

    @Test
    fun testSqrt() {
        assertEquals("1^1=1", 1,tc.sqrt(1))
        assertEquals("2^2=4", 2, tc.sqrt(4))
        assertEquals("3^3=9", 3,tc.sqrt(9))
    }
}