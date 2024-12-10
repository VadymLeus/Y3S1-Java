package com.education.ztu.TASK_02;

import java.util.Scanner;
public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println("Suma: " + sum);
    }
}