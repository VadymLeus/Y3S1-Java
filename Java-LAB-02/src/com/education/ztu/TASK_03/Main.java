package com.education.ztu.TASK_03;

public class Main {
    public static void main(String[] args) {
        System.out.println("Addition: " + Operation.addition(1, 2, 3, 4));
        System.out.println("Subtraction: " + Operation.subtraction(10, 3, 2));
        System.out.println("Multiplication: " + Operation.multiplication(2, 3, 4));
        System.out.println("Division: " + Operation.division(100.0, 5.0, 2.0));
        System.out.println("Average: " + Operation.average(5, 10, 15));
        System.out.println("Maximum: " + Operation.maximum(1, 2, 10, 3));
        System.out.println("Minimum: " + Operation.minimum(1, 2, 10, 3));

        System.out.println("\nAll locations:");
        for (Location loc : Location.values()) {
            System.out.println(loc);
        }
    }
}
