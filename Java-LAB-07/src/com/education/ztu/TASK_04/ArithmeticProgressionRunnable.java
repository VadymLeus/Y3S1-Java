package com.education.ztu.TASK_04;

public class ArithmeticProgressionRunnable implements Runnable {
    private static int result = 1;
    private synchronized void printNextProgression() {
        if (result <= 100) {
            System.out.print(result + " ");
            result++;
        }
    }

    @Override
    public void run() {
        while (result <= 100) {
            printNextProgression();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": Потік перервано.");
                return;
            }
        }
    }
}
