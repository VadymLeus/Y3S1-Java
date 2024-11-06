package TASK_02;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        System.out.println("Стан потоку перед запуском: " + myThread.getState());

        myThread.start();
        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріоритет потоку: " + myThread.getPriority());
        System.out.println("Чи є потік живим: " + myThread.isAlive());
        System.out.println("Чи є потік демоном: " + myThread.isDaemon());
        System.out.println("Стан потоку після запуску: " + myThread.getState());
        myThread.setName("NewMyThread");
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Нове ім'я потоку: " + myThread.getName());
        System.out.println("Новий пріоритет потоку: " + myThread.getPriority());

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Стан потоку після завершення: " + myThread.getState());

        Thread mainThread = Thread.currentThread();
        System.out.println("Ім'я головного потоку: " + mainThread.getName());
        System.out.println("Пріоритет головного потоку: " + mainThread.getPriority());
    }
}