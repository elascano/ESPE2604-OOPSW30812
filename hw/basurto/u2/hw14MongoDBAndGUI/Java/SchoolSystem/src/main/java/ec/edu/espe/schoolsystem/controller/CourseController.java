/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.controller;

import ec.edu.espe.schoolsystem.dao.CourseDAO;
import ec.edu.espe.schoolsystem.model.Course;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseController {

    private final CourseDAO dao =
            new CourseDAO();

    public void save(Course course) {

        dao.save(course);
    }

    public Course findById(String id) {

        return dao.findById(id);
    }

    public void delete(String id) {

        dao.delete(id);
    }
}