package com.education.ztu;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class Task_Test_Junit_Parameterized {

    private final int input;
    private final int[] expected;
    private Task task;

    public Task_Test_Junit_Parameterized(int input, int[] expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, new int[]{1}},
                {2, new int[]{1, 1}},
                {5, new int[]{1, 1, 2, 3, 5}}
        });
    }

    @Before
    public void setUp() {
        task = new Task();
    }

    @Test
    public void testGenerateFibonacci() {
        assertArrayEquals(expected, task.generateFibonacci(input));
    }
}
