package T2;

public class Engine {
    private boolean engineWorks = false;

    public void startEngine() {
        engineWorks = true;
        System.out.println("Engine started.");
    }



    public boolean isEngineWorks() {
        return engineWorks;
    }
}
