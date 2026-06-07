/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.controller;

import ec.edu.espe.schoolsystem.dao.TeacherDAO;
import ec.edu.espe.schoolsystem.model.Teacher;


/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class TeacherController {

    private final TeacherDAO dao =
            new TeacherDAO();

    public void save(Teacher teacher) {

        dao.save(teacher);
    }

    public Teacher findById(String id) {

        return dao.findById(id);
    }

    public void delete(String id) {

        dao.delete(id);
    }
}