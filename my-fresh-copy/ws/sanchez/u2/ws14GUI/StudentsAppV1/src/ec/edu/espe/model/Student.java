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

    private String idNumber;
    private String name;
    private int age;
    private String career;
    private ArrayList<Double> grades;

    public Student() {}

    public Student(String idNumber, String name, int age, String career, ArrayList<Double> grades) {
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.career = career;
        this.grades = grades;
    }

    public String getIdNumber() { return idNumber; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCareer() { return career; }
    public ArrayList<Double> getGrades() { return grades; }

    public double calculateGPA() {

        if (grades == null || grades.isEmpty()) return 0;

        double sum = 0;

        for (double g : grades) {
            sum += g;
        }

        return sum / grades.size();
    }
}
