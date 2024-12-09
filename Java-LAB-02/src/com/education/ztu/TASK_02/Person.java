package com.education.ztu.TASK_02;
public abstract class Person implements Human {
    private int age;
    private String firstname;
    private String lastname;
    private Gender gender;
    private Location location;
    protected String fullInfo;
    private static int counter = 0;
    {
        age = 0;
        firstname = "Unknown";
        lastname = "Unknown";
        gender = Gender.MALE;
        location = Location.KIEV;
        fullInfo = "";
        counter++;
    }

    public Person() {}

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.fullInfo = firstname + " " + lastname + ", " + age + ", " + gender + ", " + location;
    }

    public abstract void getOccupation();

    @Override
    public void sayFullName() {
        System.out.println(firstname + " " + lastname);
    }

    @Override
    public void sayAge() {
        System.out.println(age);
    }

    @Override
    public void sayLocation() {
        System.out.println(location);
    }

    @Override
    public void sayGender() {
        System.out.println(gender);
    }

    public String getFullInfo() {
        return fullInfo;
    }

    public static void showCounter() {
        System.out.println("Created persons: " + counter);
    }
}
