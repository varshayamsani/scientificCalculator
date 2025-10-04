
import static org.junit.jupiter.api.Assertions.*;

import org.example.Main;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(3.0, Main.squareRoot(9), 0.0001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Main.factorial(5));
    }

    @Test
    public void testNaturalLog() {
        assertEquals(0.0, Main.naturalLog(1), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(8.0, Main.power(2, 3), 0.0001);
    }

    @Test
    public void testNegativeSquareRoot() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.squareRoot(-1);
        });
    }
}
