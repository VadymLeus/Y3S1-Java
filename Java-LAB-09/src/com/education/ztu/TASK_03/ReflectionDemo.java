package com.education.ztu.TASK_03;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Getting a Class 3 object in the following ways
            Class<?> cls1 = CustomClass.class;
            Class<?> cls2 = new CustomClass().getClass();
            Class<?> cls3 = Class.forName("com.education.ztu.TASK_03.CustomClass");

            System.out.println("Class obtained by three different ways:");
            System.out.println(cls1);
            System.out.println(cls2);
            System.out.println(cls3);
            System.out.println();

            // Withdrawing everything
            System.out.println("Fields:");
            for (Field field : cls1.getDeclaredFields()) {
                System.out.println("Name: " + field.getName() + ", Type: " + field.getType().getName());
            }

            System.out.println("\nMethods:");
            for (Method method : cls1.getDeclaredMethods()) {
                System.out.print("Name: " + method.getName());
                System.out.print(", Return Type: " + method.getReturnType().getName());
                System.out.print(", Parameter Types: ");
                Class<?>[] paramTypes = method.getParameterTypes();
                for (Class<?> paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : cls1.getDeclaredConstructors()) {
                System.out.print("Name: " + constructor.getName());
                System.out.print(", Parameter Types: ");
                Class<?>[] paramTypes = constructor.getParameterTypes();
                for (Class<?> paramType : paramTypes) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }
            System.out.println();

            // An instance of a class
            CustomClass customInstance = (CustomClass) cls1.getConstructor().newInstance();
            System.out.println("Instance created: " + customInstance);

            // The challenge of the public method
            Method publicMethod = cls1.getMethod("publicMethod");
            publicMethod.invoke(customInstance);

            // Accessing a private field (getting and setting a value)
            Field privateField = cls1.getDeclaredField("privateField");
            privateField.setAccessible(true);
            privateField.setInt(customInstance, 42);
            System.out.println("Private field value set to: " + privateField.getInt(customInstance));

            // Calling a private method
            Method privateMethod = cls1.getDeclaredMethod("privateMethod", String.class);
            privateMethod.setAccessible(true);
            String result = (String) privateMethod.invoke(customInstance, "Hello from Reflection!");
            System.out.println("Private method result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
