/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.model;

import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Student {
    private String id;
    private String name;
    private String email;
    private String studentId;
    private String course;
    private List<String> enrolledCourses;
    private double gpa;
    
    public Student() {
        this.enrolledCourses = new ArrayList<>();
    }
    
    public Student(String name, String email, String studentId, String course) {
        this.name = name;
        this.email = email;
        this.studentId = studentId;
        this.course = course;
        this.enrolledCourses = new ArrayList<>();
        this.gpa = 0.0;
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    
    public List<String> getEnrolledCourses() { return enrolledCourses; }
    public void setEnrolledCourses(List<String> enrolledCourses) { this.enrolledCourses = enrolledCourses; }
    
    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    
    public void addCourse(String course) {
        this.enrolledCourses.add(course);
    }
    
    public Document toDocument() {
        return new Document("name", name)
                .append("email", email)
                .append("studentId", studentId)
                .append("course", course)
                .append("enrolledCourses", enrolledCourses)
                .append("gpa", gpa);
    }
    
    public static Student fromDocument(Document doc) {
        Student student = new Student();
        student.setId(doc.getObjectId("_id").toString());
        student.setName(doc.getString("name"));
        student.setEmail(doc.getString("email"));
        student.setStudentId(doc.getString("studentId"));
        student.setCourse(doc.getString("course"));
        student.setEnrolledCourses(doc.getList("enrolledCourses", String.class));
        student.setGpa(doc.getDouble("gpa"));
        return student;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                ", course='" + course + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
    
