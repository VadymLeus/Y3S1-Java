public class Task_Test_Mockito_Service {
    private final Task task;

    public Task_Test_Mockito_Service(Task task) {
        this.task = task;
    }

    public int[] processFibonacci(int n) {
        return task.generateFibonacci(n);
    }
}
