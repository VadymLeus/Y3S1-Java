package com.education.ztu.TASK_02_03;

import java.util.function.Supplier;

public class MainC {
    public static void main(String[] args) {
        Supplier<String> upperCaseSentence = () -> "this sentence is in upper case".toUpperCase();

        System.out.println(upperCaseSentence.get());
    }
}
