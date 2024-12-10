package com.education.ztu;

public class Task {
    public int[] generateFibonacci(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        int[] fibonacci = new int[n];
        if (n >= 1) fibonacci[0] = 1;
        if (n >= 2) fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }
}
