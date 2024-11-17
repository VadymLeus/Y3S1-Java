package TASK_03;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Отримання об'єкта Class 3 способами
            Class<?> cls1 = CustomClass.class;
            Class<?> cls2 = new CustomClass().getClass();
            Class<?> cls3 = Class.forName("TASK_03.CustomClass");

            System.out.println("Class obtained by three different ways:");
            System.out.println(cls1);
            System.out.println(cls2);
            System.out.println(cls3);
            System.out.println();

            // Виведення всього
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

            // Екземпляр класу
            CustomClass customInstance = (CustomClass) cls1.getConstructor().newInstance();
            System.out.println("Instance created: " + customInstance);

            // Виклик публічного методу
            Method publicMethod = cls1.getMethod("publicMethod");
            publicMethod.invoke(customInstance);

            // Доступ до приватного поля (отримання і встановлення значення)
            Field privateField = cls1.getDeclaredField("privateField");
            privateField.setAccessible(true);
            privateField.setInt(customInstance, 42);
            System.out.println("Private field value set to: " + privateField.getInt(customInstance));

            // Виклик приватного методу
            Method privateMethod = cls1.getDeclaredMethod("privateMethod", String.class);
            privateMethod.setAccessible(true);
            String result = (String) privateMethod.invoke(customInstance, "Hello from Reflection!");
            System.out.println("Private method result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
