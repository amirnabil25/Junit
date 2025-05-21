

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

//@ExtendWith(org.junit.jupiter.api.extension.Extension.class)
class ExampleTestJunitFiveTest {


    // JUnit 5 uses @Test annotation from 'org.junit.jupiter.api'
    @org.junit.jupiter.api.Test
    void testAddition() {
        int result = 2 + 3;
        org.junit.jupiter.api.Assertions.assertEquals(5, result);  // JUnit 5 uses assertEquals from org.junit.jupiter.api.Assertions
    }

    // Example of a test with setup and teardown using @BeforeEach and @AfterEach
    @org.junit.jupiter.api.BeforeEach
    void setup() {
        System.out.println("Before Each");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("After Each");
    }

    // Example of grouping tests using @BeforeAll and @AfterAll for setup/teardown
    @org.junit.jupiter.api.BeforeAll
    static void beforeClass() {
        System.out.println("Before All");
    }

    @org.junit.jupiter.api.AfterAll
    static void afterClass() {
        System.out.println("After All");
        // This runs once after all tests in the class
    }

    @org.junit.jupiter.api.Nested
    class NestedTest {

        @org.junit.jupiter.api.Test
        void testInNested() {
            org.junit.jupiter.api.Assertions.assertEquals(5, 2 + 3);
        }
    }

    @org.junit.jupiter.params.ParameterizedTest
    @org.junit.jupiter.params.provider.ValueSource(ints = {1, 2, 3, 4})
    void testWithParameters(int number) {
        org.junit.jupiter.api.Assertions.assertTrue(number > 0);
    }


    static class CustomObjectTest {

        static class User {
            String name;
            int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }


    }
    static Stream<Arguments> userProvider() {
        return Stream.of(
                Arguments.of(new CustomObjectTest.User("Alice", 30)),
                Arguments.of(new CustomObjectTest.User("Bob", 25))
        );
    }
    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("userProvider")
    void testWithObjects(CustomObjectTest.User user) {
        Assertions.assertNotNull(user.name);
        Assertions.assertTrue(user.age > 0);
    }

    @org.junit.jupiter.api.TestFactory
    Stream<org.junit.jupiter.api.DynamicTest> dynamicTests() {
        return Stream.of(
                org.junit.jupiter.api.DynamicTest.dynamicTest("Test 1", () -> org.junit.jupiter.api.Assertions.assertEquals(2 + 3, 5)),
        org.junit.jupiter.api.DynamicTest.dynamicTest("Test 2", () -> org.junit.jupiter.api.Assertions.assertEquals(3 + 3, 6))
        );
    }



    @org.junit.jupiter.api.RepeatedTest(3)
    void repeatedTest() {
        org.junit.jupiter.api.Assertions.assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Timeout(value = 2, unit = TimeUnit.SECONDS) // fails if takes longer than 2 seconds
    void testWithTimeout() throws InterruptedException {
        Thread.sleep(1000);
    }

    @org.junit.jupiter.api.Test
    void testThrowsException() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Error");
        });
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Tag("fast")
    void taggedTest() {
        System.out.println("taggedTest1");

        org.junit.jupiter.api.Assertions.assertTrue(true);
    }

    @org.junit.jupiter.api.Test
    @org.junit.jupiter.api.Tag("fast")
    void taggedTest2() {
        System.out.println("taggedTest2");
        org.junit.jupiter.api.Assertions.assertTrue(true);
    }



    @org.junit.jupiter.api.Test
    @Disabled
    void disabledTestThrowsException() {
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Error");
        });
    }
}
