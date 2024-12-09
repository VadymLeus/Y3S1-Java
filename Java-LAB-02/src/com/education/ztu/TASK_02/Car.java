package com.education.ztu.TASK_02;

public class Car {
    private String brand;
    private Engine engine;

    public Car(String brand) {
        this.brand = brand;
        this.engine = new Engine();
    }

    public Engine getEngine() {
        return this.engine;
    }

    public boolean engineIsRunning() {
        return engine.isEngineWorks();
    }
}
