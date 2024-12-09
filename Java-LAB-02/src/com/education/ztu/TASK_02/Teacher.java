package com.education.ztu.TASK_02;
public class Teacher extends Person {
    private String subject;
    private String university;
    private Car car;
    private static int counter = 0;

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    @Override
    public void getOccupation() {
        System.out.println("I am a teacher.");
    }

    public static void showCounter() {
        System.out.println("Created teachers: " + counter);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
