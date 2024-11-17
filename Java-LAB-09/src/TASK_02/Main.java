package TASK_02;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Список людей
        List<Employee> employees = Arrays.asList(
                new Employee("Іван Іваненко", "20.05.1995", "Менеджер", "5 років", "Київ, вул. Хрещатик, 10", "ivan.ivanenko@example.com", "+380501234567"),
                new Employee("Петро Петренко", "15.11.1987", "Розробник", "10 років", "Львів, вул. Стрийська, 5", "petro.petrenko@example.com", "+380931234567"),
                new Employee("Олена Олененко", "03.07.1992", "Аналітик", "8 років", "Одеса, вул. Дерибасівська, 1", "olena.olenko@example.com", "+380671234567"),
                new Employee("Сергій Сергієнко", "01.01.1980", "HR-менеджер", "12 років", "Харків, вул. Сумська, 15", "sergiy.sergienko@example.com", "+380661234567"),
                new Employee("Наталія Наталенко", "30.09.1990", "Дизайнер", "6 років", "Дніпро, вул. Поля, 8", "natalia.natalenko@example.com", "+380991234567"),
                new Employee("Андрій Андрієнко", "25.03.1985", "Проєктний менеджер", "15 років", "Запоріжжя, вул. Миру, 20", "andriy.andrienko@example.com", "+380501111111"),
                new Employee("Марія Марієнко", "10.12.1993", "Маркетолог", "4 роки", "Київ, вул. Грушевського, 25", "maria.marienko@example.com", "+380671000000")
        );

        // 1. Пошул телефонів та емейлів
        System.out.println("Знайдені телефони:");
        employees.forEach(emp -> System.out.println(emp.getPhone()));

        System.out.println("\nЗнайдені емейли:");
        employees.forEach(emp -> System.out.println(emp.getEmail()));

        // 2. Зміна формау днів народження
        Pattern datePattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        employees.forEach(emp -> {
            Matcher matcher = datePattern.matcher(emp.getBirthDate());
            if (matcher.matches()) {
                String newDate = matcher.group(3) + "-" + matcher.group(2) + "-" + matcher.group(1);
                emp.setBirthDate(newDate);
            }
        });

        // 3. Зміна посади
        employees.get(0).setPosition("Старший менеджер");
        employees.get(3).setPosition("Директор з персоналу");
        employees.get(6).setPosition("Керівник відділу маркетингу");

        // 4. Результат
        System.out.println("\nОновлені дані співробітників:");
        employees.forEach(System.out::println);
    }
}
