package com.education.ztu.TASK_07;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final int ARRAY_SIZE = 1_000_000;
    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws Exception {
        int[] array = new int[ARRAY_SIZE];
        Random random = new Random();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = random.nextInt(1000);
        }

        long startTime = System.currentTimeMillis();
        int singleThreadSum = calculateSumSingleThread(array);
        long singleThreadDuration = System.currentTimeMillis() - startTime;

        System.out.println("Suma (single stream): " + singleThreadSum);
        System.out.println("Execution time (single-threaded): " + singleThreadDuration + " ms");

        startTime = System.currentTimeMillis();
        int multiThreadSum = calculateSumMultiThread(array);
        long multiThreadDuration = System.currentTimeMillis() - startTime;

        System.out.println("Amount (multi-threaded): " + multiThreadSum);
        System.out.println("Execution time (multi-threaded): " + multiThreadDuration + " ms");
    }

    private static int calculateSumSingleThread(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += sumOfDigits(num);
        }
        return sum;
    }

    private static int calculateSumMultiThread(int[] array) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<Integer>> futures = new ArrayList<>();

        int partSize = ARRAY_SIZE / THREAD_COUNT;
        for (int i = 0; i < THREAD_COUNT; i++) {
            int start = i * partSize;
            int end = (i == THREAD_COUNT - 1) ? ARRAY_SIZE : (i + 1) * partSize;

            Callable<Integer> task = new SumTask(array, start, end);
            futures.add(executorService.submit(task));
        }

        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executorService.shutdown();
        return totalSum;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
