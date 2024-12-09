package com.education.ztu.TASK_03;

public class Task_03 {
    public static void Main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);
            if (i < args.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
