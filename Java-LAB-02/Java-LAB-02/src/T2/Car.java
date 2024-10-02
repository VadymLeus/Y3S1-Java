package T2;
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
        return engine.engineWorks;
    }

    public class Engine {
        private boolean engineWorks = false;

        public void startEngine() {
            engineWorks = true;
            System.out.println("Engine started.");
        }

        public void stopEngine() {
            engineWorks = false;
            System.out.println("Engine stopped.");
        }

        public boolean isEngineWorks() {
            return engineWorks;
        }
    }
}
