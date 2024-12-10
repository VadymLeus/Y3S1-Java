package com.education.ztu.TASK_04;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Creating an annotation
@Target(ElementType.TYPE) // Can be applied to classes or interfaces
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
public @interface MyAnnotation {
    String author() default "Anonymous"; // The default value is
    String version() default "1.0"; // The default value is
    String description() default "No description provided"; // Extra field
}
