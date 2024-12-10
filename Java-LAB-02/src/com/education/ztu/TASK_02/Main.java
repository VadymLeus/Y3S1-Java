package com.education.ztu.TASK_02;
public class Main {
    public static void main(String[] args) {
        Car teacherCar = new Car("Toyota");
        Teacher teacher = new Teacher("John", "Doe", 35, Gender.MALE, Location.KIEV, "Math", "University of Kiev", teacherCar);

        Car employeeCar = new Car("BMW");
        Employee employee = new Employee("Alice", "Smith", 28, Gender.FEMALE, Location.VINNYTSYA, "TechCorp", "Developer", employeeCar);

        Student student = new Student("Bob", "Johnson", 20, Gender.MALE, Location.ZHYTOMYR, "Computer Science", "Software Engineering", "University of ZHYTOMYR");

        teacher.sayFullName();
        employee.sayLocation();
        student.sayAge();

        teacher.getOccupation();
        employee.getOccupation();
        student.getOccupation();

        System.out.println("Is teacher's car engine running? " + teacherCar.engineIsRunning());
        teacherCar.getEngine().startEngine();
        System.out.println("Is teacher's car engine running? " + teacherCar.engineIsRunning());

        Teacher.showCounter();
        Student.showCounter();
        Employee.showCounter();
        if (teacher instanceof Person) {
            System.out.println("Teacher is a Person.");
        }
    }
}
