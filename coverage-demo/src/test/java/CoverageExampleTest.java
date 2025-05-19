
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoverageExampleTest {

    @Test
    void testIsPositive() {
        CoverageExample example = new CoverageExample();
        Assertions.assertTrue(example.isPositive(5));
        Assertions.assertFalse(example.isPositive(-1));
    }

    @Test
    void testIsEven() {
        CoverageExample example = new CoverageExample();
        Assertions.assertTrue(example.isEven(4));
        Assertions.assertFalse(example.isEven(3));
    }
}
