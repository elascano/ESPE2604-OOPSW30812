/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativesoftware.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */

public class Course {

    private String courseId;
    private String name;
    private String subject;
    private String description;
    private String teacher;
    private List<Student> students;

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", name=" + name + ", subject=" + subject + ", description=" + description + ", teacher=" + teacher + ", students=" + students + '}';
    }




    public Course() {

        students = new ArrayList<>();

    }

    public Course(String courseId,
            String name,
            String subject,
            String description,
            String teacher) {

        this.courseId = courseId;
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.teacher = teacher;

        students = new ArrayList<>();

    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    
}