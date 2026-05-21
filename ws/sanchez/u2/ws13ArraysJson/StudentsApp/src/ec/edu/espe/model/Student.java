/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private String subject;
    private int age;
    private ArrayList<Integer> grades;

    public Student() {
        this.grades = new ArrayList<>();
    }

    public Student(String firstName, String lastName, String subject, int age, ArrayList<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.age = age;
        this.grades = grades;
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;

        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "\nName: " + firstName + " " + lastName +
               "\nSubject: " + subject +
               "\nAge: " + age +
               "\nGrades: " + grades +
               "\nAverage: " + String.format("%.2f", getAverage());
    }


    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public ArrayList<Integer> getGrades() { return grades; }
    public void setGrades(ArrayList<Integer> grades) { this.grades = grades; }
}

