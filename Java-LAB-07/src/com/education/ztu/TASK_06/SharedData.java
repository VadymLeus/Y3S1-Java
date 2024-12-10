package com.education.ztu.TASK_06;

public class SharedData {
    private String data;

    public synchronized void setData(String data) {
        this.data = data;
        notify();
    }

    public synchronized String getData() {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return data;
    }
}
