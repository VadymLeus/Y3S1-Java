package TASK_02_03;

import java.util.function.Supplier;

public class MainC {
    public static void main(String[] args) {
        Supplier<String> upperCaseSentence = () -> "це речення у верхньому регістрі".toUpperCase();

        System.out.println(upperCaseSentence.get());
    }
}
