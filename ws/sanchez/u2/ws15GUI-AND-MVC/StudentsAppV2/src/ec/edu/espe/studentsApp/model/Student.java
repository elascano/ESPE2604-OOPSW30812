/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsApp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */


public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private Map<String, ArrayList<Double>> subjectsGrades;

    public Student() {
        subjectsGrades = new HashMap<>();
    }

    public Student(String firstName, String lastName, int age, Map<String, ArrayList<Double>> subjectsGrades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjectsGrades = subjectsGrades;
    }

    public double getOverallAverage() {
        if (subjectsGrades == null || subjectsGrades.isEmpty()) return 0;
        double totalSum = 0;
        int totalGrades = 0;
        for (ArrayList<Double> grades : subjectsGrades.values()) {
            for (double grade : grades) {
                totalSum += grade;
                totalGrades++;
            }
        }
        return totalGrades == 0 ? 0 : totalSum / totalGrades;
    }

    // Getters y Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public Map<String, ArrayList<Double>> getSubjectsGrades() { return subjectsGrades; }
    public void setSubjectsGrades(Map<String, ArrayList<Double>> subjectsGrades) { this.subjectsGrades = subjectsGrades; }
}