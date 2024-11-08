package TASK_02_03;

import java.util.function.Consumer;

public class MainB {
    public static void main(String[] args) {
        Consumer<String> startClass = str -> System.out.println("Пара почалася о 8:30");
        Consumer<String> endClass = str -> System.out.println("Пара закінчилася о 9:50");

        startClass.andThen(endClass).accept("Пара");
    }
}
