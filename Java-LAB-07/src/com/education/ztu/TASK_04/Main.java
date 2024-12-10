package com.education.ztu.TASK_04;

public class Main {
    public static void main(String[] args) {
        ArithmeticProgressionRunnable task = new ArithmeticProgressionRunnable();

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
