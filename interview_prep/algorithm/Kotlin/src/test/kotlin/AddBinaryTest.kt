import hoa.can.code.AddBinary
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals

internal class AddBinaryTest {
    private val tc: AddBinary = AddBinary()

    @Test
    fun testSum() {
        assertEquals("11+1=100", tc.addBinary("11","1"),"100")
        Assertions.assertEquals("10101", tc.addBinary("1010", "1011"),"10101")
    }
}