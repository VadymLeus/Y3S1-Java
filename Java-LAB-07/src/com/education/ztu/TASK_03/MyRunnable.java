package com.education.ztu.TASK_03;
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ": Потік було перервано перед початком.");
            return;
        }

        for (int i = 0; i <= 10000; i++) {
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

            if (i == 9990 || Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ": Розрахунок завершено!!!");
                return;
            }
        }
    }
}