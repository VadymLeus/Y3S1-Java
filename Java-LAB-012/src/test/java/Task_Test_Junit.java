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
        System.out.println("BeforeClass: Виконується перед запуском усіх тестів.");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("AfterClass: Виконується після завершення всіх тестів.");
    }

    @Before
    public void setUp() {
        System.out.println("Before: Ініціалізація перед кожним тестом.");
        task = new Task();
    }

    @After
    public void tearDown() {
        System.out.println("After: Очищення після кожного тесту.");
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

    @Ignore("Цей тест пропущено, оскільки не завершено.")
    @Test
    public void ignoredTest() {
        fail("Цей тест не повинен бути виконаний.");
    }
}
