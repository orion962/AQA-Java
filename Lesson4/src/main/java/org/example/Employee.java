package org.example;

public class Employee {
    String fullName;
    String job;
    String email;
    String phoneNumber;
    int salary;
    int age;

    Employee(String fullName, String job, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void printString() {
        System.out.printf("%s, %s, %s, %s, %d, %d", fullName, job, email, phoneNumber, salary, age);
        System.out.println();
    }
}