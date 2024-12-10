package com.education.ztu.TASK_02;
public class Student extends Person {
    private String course;
    private String speciality;
    private String university;
    private static int counter = 0;

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String course, String speciality, String university) {
        super(firstname, lastname, age, gender, location);
        this.course = course;
        this.speciality = speciality;
        this.university = university;
        counter++;
    }
    @Override
    public void getOccupation() {
        System.out.println("I am a student.");
    }

    public static void showCounter() {
        System.out.println("Created students: " + counter);
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}



