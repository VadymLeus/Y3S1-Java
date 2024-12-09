package com.education.ztu.TASK_04;

@MyAnnotation(
        author = "John Doe",
        version = "2.0",
        description = "This is a sample class with MyAnnotation"
)
public class AnnotatedClass {
    public void display() {
        System.out.println("AnnotatedClass method is called.");
    }
}
