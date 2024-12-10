package com.education.ztu;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task_Test {
    private final Task task = new Task();

    @Test
    public void testGenerateFibonacciWithSmallNumber() {
        int[] result = task.generateFibonacci(5);
        assertThat(result).containsExactly(1, 1, 2, 3, 5);
    }

    @Test
    public void testGenerateFibonacciWithOneElement() {
        int[] result = task.generateFibonacci(1);
        assertThat(result).containsExactly(1);
    }

    @Test
    public void testGenerateFibonacciWithTwoElements() {
        int[] result = task.generateFibonacci(2);
        assertThat(result).containsExactly(1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGenerateFibonacciWithInvalidInput() {
        task.generateFibonacci(0);
    }
}
