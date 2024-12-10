package com.education.ztu.TASK_03;

public class CustomClass {
    public String publicField;
    private int privateField;

    public CustomClass() {
        this.publicField = "Default";
        this.privateField = 0;
    }

    public CustomClass(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    private String privateMethod(String message) {
        return "Private method says: " + message;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }
}
