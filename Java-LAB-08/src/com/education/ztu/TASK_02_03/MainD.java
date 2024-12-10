package com.education.ztu.TASK_02_03;

import java.util.function.Function;
import java.util.Arrays;

public class MainD {
    public static void main(String[] args) {
        Function<String, Integer> multiplyNumbers = str -> Arrays.stream(str.split(" "))
                .map(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);

        System.out.println(multiplyNumbers.apply("2 3 4")); // 24
        System.out.println(multiplyNumbers.apply("1 5 7")); // 35
    }
}
