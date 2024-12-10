package com.education.ztu.TASK_06;

public class ReaderPrinterExample {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread readerThread = new Thread(new Reader(sharedData));
        Thread printerThread = new Thread(new Printer(sharedData));

        readerThread.start();
        printerThread.start();
    }
}

