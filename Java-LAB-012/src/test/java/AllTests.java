import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Task_Test.class,
        Task_Test_Junit.class,
        Task_Test_Junit_Parameterized.class,
        Task_Test_Mockito.class
})
public class AllTests {
}
