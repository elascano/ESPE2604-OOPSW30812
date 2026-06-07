/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Course {

    private String id;
    private String name;
    private String teacher;

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", teacher=" + teacher + '}';
    }

    public Course() {
    }

    public Course(String id,
                  String name,
                  String teacher) {

        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    
}