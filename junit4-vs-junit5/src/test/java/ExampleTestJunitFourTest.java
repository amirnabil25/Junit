import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;

@RunWith(org.junit.runners.JUnit4.class)
public class ExampleTestJunitFourTest {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5); // Fails if a test runs longer than 5 seconds



    // Example of grouping tests using @BeforeClass and @AfterClass for setup/teardown
    @org.junit.BeforeClass
    public static void beforeClass() {
        // This runs before any tests in the class
    }

    // Example of a test with setup and teardown using @Before and @After
    @org.junit.Before
    public void setup() {
        // setup code before each test (like initializing objects)
    }


    // JUnit 4 uses @Test annotation from the 'org.junit' package
    @org.junit.Test // JUnit 4 import
    public void testAddition() {
        int result = 2 + 3;
        org.junit.Assert.assertEquals(5, result);  // JUnit 4 uses assertEquals from org.junit.Assert
    }

    @Ignore("Temporarily disabled due to bug")
    @org.junit.Test
    public void ignoredTest() {
        // Skipped test
    }

    @org.junit.After
    public void tearDown() {
        // teardown code after each test (like releasing resources)
    }

    @org.junit.AfterClass
    public static void afterClass() {
        // This runs after all tests in the class
    }
}
