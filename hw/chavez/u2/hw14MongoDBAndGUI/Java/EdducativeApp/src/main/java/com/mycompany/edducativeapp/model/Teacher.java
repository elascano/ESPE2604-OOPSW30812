/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.model;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Teacher {
    private String id;
    private String name;
    private String email;
    private String teacherId;
    private String department;
    private List<String> coursesTeaching;
    private String specialization;
    
    public Teacher() {
        this.coursesTeaching = new ArrayList<>();
    }
    
    public Teacher(String name, String email, String teacherId, String department, String specialization) {
        this.name = name;
        this.email = email;
        this.teacherId = teacherId;
        this.department = department;
        this.specialization = specialization;
        this.coursesTeaching = new ArrayList<>();
    }
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public List<String> getCoursesTeaching() { return coursesTeaching; }
    public void setCoursesTeaching(List<String> coursesTeaching) { this.coursesTeaching = coursesTeaching; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public void addCourse(String course) {
        this.coursesTeaching.add(course);
    }
    
    public Document toDocument() {
        return new Document("name", name)
                .append("email", email)
                .append("teacherId", teacherId)
                .append("department", department)
                .append("coursesTeaching", coursesTeaching)
                .append("specialization", specialization);
    }
    
    public static Teacher fromDocument(Document doc) {
        Teacher teacher = new Teacher();
        teacher.setId(doc.getObjectId("_id").toString());
        teacher.setName(doc.getString("name"));
        teacher.setEmail(doc.getString("email"));
        teacher.setTeacherId(doc.getString("teacherId"));
        teacher.setDepartment(doc.getString("department"));
        teacher.setCoursesTeaching(doc.getList("coursesTeaching", String.class));
        teacher.setSpecialization(doc.getString("specialization"));
        return teacher;
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", department='" + department + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
    
}
