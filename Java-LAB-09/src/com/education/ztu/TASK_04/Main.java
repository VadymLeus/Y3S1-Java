package com.education.ztu.TASK_04;

public class Main {
    public static void main(String[] args) {
        // Отримання класу AnnotatedClass
        Class<AnnotatedClass> clazz = AnnotatedClass.class;

        // Перевірка наявності анотації
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            // Отримання даних з анотації
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);

            // Вивід даних у консоль
            System.out.println("Author: " + annotation.author());
            System.out.println("Version: " + annotation.version());
            System.out.println("Description: " + annotation.description());
        } else {
            System.out.println("No annotation found on class AnnotatedClass.");
        }

        // Виклик метода класа
        AnnotatedClass obj = new AnnotatedClass();
        obj.display();
    }
}
