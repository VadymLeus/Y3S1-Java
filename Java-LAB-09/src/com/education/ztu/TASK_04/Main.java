package com.education.ztu.TASK_04;

public class Main {
    public static void main(String[] args) {
        // Getting the AnnotatedClass class
        Class<AnnotatedClass> clazz = AnnotatedClass.class;

        // Checking the availability of an annotation
        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            // Retrieving data from an annotation
            MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);

            // Data output to the console
            System.out.println("Author: " + annotation.author());
            System.out.println("Version: " + annotation.version());
            System.out.println("Description: " + annotation.description());
        } else {
            System.out.println("No annotation found on class AnnotatedClass.");
        }

        AnnotatedClass obj = new AnnotatedClass();
        obj.display();
    }
}
