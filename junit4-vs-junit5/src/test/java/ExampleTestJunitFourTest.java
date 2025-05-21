import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.JUnit4.class)
public class ExampleTestJunitFourTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(1000); // Fails if a test runs longer than 5 seconds



    // Example of grouping tests using @BeforeClass and @AfterClass for setup/teardown
    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("Before class");
        // This runs before any tests in the class
    }

    // Example of a test with setup and teardown using @Before and @After
    @org.junit.Before
    public void setup() {
        System.out.println("Before test");
        // setup code before each test (like initializing objects)
    }


    // JUnit 4 uses @Test annotation from the 'org.junit' package
    @org.junit.Test // JUnit 4 import
    public void testAddition() {

        System.out.println("Running Test");
        int result = 2 + 3;
        org.junit.Assert.assertEquals(5, result);  // JUnit 4 uses assertEquals from org.junit.Assert
    }

    @Ignore("Temporarily disabled due to bug")
    @org.junit.Test
    public void ignoredTest() {
        // Skipped test
        System.out.println("Ignored test");
    }

    @org.junit.Test
    public void ignored2Test() {
        // Skipped test
        System.out.println("Ignored test");
    }

    @org.junit.After
    public void tearDown() {
        System.out.println("After Test");
        // teardown code after each test (like releasing resources)
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("After class");
        // This runs after all tests in the class
    }
}
