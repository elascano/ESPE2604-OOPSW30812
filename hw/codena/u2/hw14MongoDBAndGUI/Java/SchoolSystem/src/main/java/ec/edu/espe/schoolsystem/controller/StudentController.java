/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.controller;

import ec.edu.espe.schoolsystem.dao.StudentDAO;
import ec.edu.espe.schoolsystem.model.Student;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class StudentController {

    private final StudentDAO dao =
            new StudentDAO();

    public void save(Student student){

        dao.save(student);
    }

    public Student findById(String id){

        return dao.findById(id);
    }

    public void delete(String id){

        dao.delete(id);
    }
}