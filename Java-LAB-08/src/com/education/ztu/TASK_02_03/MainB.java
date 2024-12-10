package com.education.ztu.TASK_02_03;

import java.util.function.Consumer;

public class MainB {
    public static void main(String[] args) {
        Consumer<String> startClass = str -> System.out.println("The pair started at 8:30 a.m.");
        Consumer<String> endClass = str -> System.out.println("The pair ended at 9:50");

        startClass.andThen(endClass).accept("Pair");
    }
}
