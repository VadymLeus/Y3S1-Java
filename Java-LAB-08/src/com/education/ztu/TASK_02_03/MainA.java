package com.education.ztu.TASK_02_03;
import java.util.function.Predicate;

public class MainA {
    public static void main(String[] args) {
        Predicate<String> isNumeric = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        System.out.println(isNumeric.test("123")); // true
        System.out.println(isNumeric.test("abc")); // false

        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Predicate<String> isValidNumber = isNumeric.and(isNotEmpty);

        System.out.println(isValidNumber.test("123")); // true
        System.out.println(isValidNumber.test(""));    // false
    }
}
