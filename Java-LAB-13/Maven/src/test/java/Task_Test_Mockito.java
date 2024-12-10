import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class Task_Test_Mockito {

    @Mock
    private Task task;

    @InjectMocks
    private Task_Test_Mockito_Service taskService;

    @Captor
    private ArgumentCaptor<Integer> argumentCaptor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGenerateFibonacciWithMock() {
        when(task.generateFibonacci(5)).thenReturn(new int[]{1, 1, 2, 3, 5});

        int[] result = task.generateFibonacci(5);

        assertArrayEquals(new int[]{1, 1, 2, 3, 5}, result);

        verify(task, times(1)).generateFibonacci(5);
    }

    @Test
    public void testGenerateFibonacciWithException() {
        when(task.generateFibonacci(0)).thenThrow(new IllegalArgumentException("n must be greater than 0"));
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> task.generateFibonacci(0)
        );

        assertEquals("n must be greater than 0", exception.getMessage());
        verify(task, times(1)).generateFibonacci(0);
    }

    @Test
    public void testDoReturnMock() {
        doReturn(new int[]{1, 1, 2, 3, 5}).when(task).generateFibonacci(5);

        int[] result = task.generateFibonacci(5);

        assertArrayEquals(new int[]{1, 1, 2, 3, 5}, result);

        verify(task, times(1)).generateFibonacci(5);
    }

    @Test
    public void testVerifyNeverCalled() {
        verify(task, never()).generateFibonacci(10);
    }

    @Test
    public void testCaptor() {
        when(task.generateFibonacci(anyInt())).thenReturn(new int[]{1, 1, 2, 3, 5});
        task.generateFibonacci(5);
        verify(task).generateFibonacci(argumentCaptor.capture());
        assertEquals(Integer.valueOf(5), argumentCaptor.getValue());
    }
}
