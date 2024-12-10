package com.education.ztu.TASK_02;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        System.out.println("The state of the thread before starting: " + myThread.getState());

        myThread.start();
        System.out.println("The name of the stream: " + myThread.getName());
        System.out.println("Flow priority: " + myThread.getPriority());
        System.out.println("Whether the stream is live:  " + myThread.isAlive());
        System.out.println("Whether the flow is a daemon: " + myThread.isDaemon());
        System.out.println("The state of the thread after launch:  " + myThread.getState());
        myThread.setName("NewMyThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("New thread name: " + myThread.getName());
        System.out.println("New thread priority: " + myThread.getPriority());

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The state of the thread after completion: " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("The name of the main thread: " + mainThread.getName());
        System.out.println("The priority of the main thread: " + mainThread.getPriority());
    }
}