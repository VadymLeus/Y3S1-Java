package com.education.ztu.TASK_02;
public class Employee {
    private String fullName;
    private String birthDate;
    private String position;
    private String experience;
    private String address;
    private String email;
    private String phone;

    public Employee(String fullName, String birthDate, String position, String experience, String address, String email, String phone) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.experience = experience;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", position='" + position + '\'' +
                ", experience='" + experience + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
