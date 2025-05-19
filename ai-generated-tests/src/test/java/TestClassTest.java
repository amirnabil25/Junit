import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TestClassTest {
    /**
     * Test {@link TestClass#isEven(int)}.
     * <ul>
     *   <li>When one.</li>
     *   <li>Then return {@code false}.</li>
     * </ul>
     * <p>
     * Method under test: {@link TestClass#isEven(int)}
     */
    @Test
    @DisplayName("Test isEven(int); when one; then return 'false'")
    @Tag("MaintainedByDiffblue")
    void testIsEven_whenOne_thenReturnFalse() {
        // Arrange, Act and Assert
        assertFalse((new TestClass()).isEven(1));
    }

    /**
     * Test {@link TestClass#isEven(int)}.
     * <ul>
     *   <li>When ten.</li>
     *   <li>Then return {@code true}.</li>
     * </ul>
     * <p>
     * Method under test: {@link TestClass#isEven(int)}
     */
    @Test
    @DisplayName("Test isEven(int); when ten; then return 'true'")
    @Tag("MaintainedByDiffblue")
    void testIsEven_whenTen_thenReturnTrue() {
        // Arrange, Act and Assert
        assertTrue((new TestClass()).isEven(10));
    }
}
