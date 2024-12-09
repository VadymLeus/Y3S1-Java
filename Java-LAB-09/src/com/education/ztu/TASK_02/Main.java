package com.education.ztu.TASK_02;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // List of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Ivan Ivanenko", "20.05.1995", "Manager", "5 years", "Kyiv, Khreshchatyk St., 10", "ivan.ivanenko@example.com", "+380501234567"),
                new Employee("Petro Petrenko", "15.11.1987", "Developer", "10 years", "Lviv, Stryiska St., 5", "petro.petrenko@example.com", "+380931234567"),
                new Employee("Olena Olenko", "03.07.1992", "Analyst", "8 years", "Odesa, Deribasivska St., 1", "olena.olenko@example.com", "+380671234567"),
                new Employee("Sergiy Sergienko", "01.01.1980", "HR Manager", "12 years", "Kharkiv, Sumskaya St., 15", "sergiy.sergienko@example.com", "+380661234567"),
                new Employee("Natalia Natalenko", "30.09.1990", "Designer", "6 years", "Dnipro, Polya St., 8", "natalia.natalenko@example.com", "+380991234567"),
                new Employee("Andriy Andrienko", "25.03.1985", "Project Manager", "15 years", "Zaporizhzhia, Miru St., 20", "andriy.andrienko@example.com", "+380501111111"),
                new Employee("Maria Marienko", "10.12.1993", "Marketer", "4 years", "Kyiv, Hrushevskoho St., 25", "maria.marienko@example.com", "+380671000000")
        );

        // 1. Find phones and emails
        System.out.println("Found phones:");
        employees.forEach(emp -> System.out.println(emp.getPhone()));

        System.out.println("\nFound emails:");
        employees.forEach(emp -> System.out.println(emp.getEmail()));

        // 2. Change the date format for birth dates
        Pattern datePattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        employees.forEach(emp -> {
            Matcher matcher = datePattern.matcher(emp.getBirthDate());
            if (matcher.matches()) {
                String newDate = matcher.group(3) + "-" + matcher.group(2) + "-" + matcher.group(1);
                emp.setBirthDate(newDate);
            }
        });

        // 3. Update positions
        employees.get(0).setPosition("Senior Manager");
        employees.get(3).setPosition("HR Director");
        employees.get(6).setPosition("Head of Marketing Department");

        // 4. Display updated employee data
        System.out.println("\nUpdated employee data:");
        employees.forEach(System.out::println);
    }
}
