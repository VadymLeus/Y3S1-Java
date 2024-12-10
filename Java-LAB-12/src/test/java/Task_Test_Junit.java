import org.junit.*;
import org.junit.rules.*;
import static org.junit.Assert.*;

public class Task_Test_Junit {

    private Task task;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public TestName testName = new TestName();

    @Rule
    public Timeout timeout = Timeout.millis(1000);

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("BeforeClass: Performed before running all tests.");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("AfterClass: Performed after running all tests.");
    }

    @Before
    public void setUp() {
        System.out.println("Before: Initialisation before each test.");
        task = new Task();
    }

    @After
    public void tearDown() {
        System.out.println("After: Cleaning after each test.");
    }

    @Test
    public void testGenerateFibonacciPositive() {
        System.out.println("Тест: " + testName.getMethodName());
        int[] result = task.generateFibonacci(5);
        assertArrayEquals(new int[]{1, 1, 2, 3, 5}, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateFibonacciWithZero() {
        System.out.println("Тест: " + testName.getMethodName());
        task.generateFibonacci(0);
    }

    @Test
    public void testGenerateFibonacciWithNull() {
        System.out.println("Тест: " + testName.getMethodName());
        int[] result = task.generateFibonacci(1);
        assertNotNull(result);
        assertArrayEquals(new int[]{1}, result);
    }

    @Ignore("This test is skipped because it is not complete.")
    @Test
    public void ignoredTest() {
        fail("This test should not be performed.");
    }
}
