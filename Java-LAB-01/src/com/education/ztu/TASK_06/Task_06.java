package com.education.ztu.TASK_06;

import java.util.Scanner;
public class Task_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.print("A straight array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
        System.out.print("\nReverse array: ");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}