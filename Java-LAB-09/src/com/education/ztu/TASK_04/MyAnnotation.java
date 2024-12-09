package com.education.ztu.TASK_04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Створення  анотації
@Target(ElementType.TYPE) // Може застосовуватись до класів або інтерфейсів
@Retention(RetentionPolicy.RUNTIME) // Доступна під час виконання
public @interface MyAnnotation {
    String author() default "Anonymous"; // Значенням за замовчуванням
    String version() default "1.0"; // Значенням за замовчуванням
    String description() default "No description provided"; // Екстра поле
}
