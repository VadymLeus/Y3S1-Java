package com.education.ztu.TASK_05;

public class ArithmeticProgressionRunnable implements Runnable {
    private static int result = 1;

    @Override
    public void run() {
        while (result <= 100) {
            synchronized (ArithmeticProgressionRunnable.class) {
                if (result <= 101) {
                    System.out.print(result + " ");
                    result++;
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": The stream is interrupted.");
                return;
            }
        }
    }
}
