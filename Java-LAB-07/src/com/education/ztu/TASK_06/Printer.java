package com.education.ztu.TASK_06;

public class Printer implements Runnable {
    private final SharedData sharedData;

    public Printer(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            String data = sharedData.getData();

            if ("exit".equalsIgnoreCase(data)) {
                break;
            }

            System.out.println("Data obtained: " + data);
        }
    }
}
