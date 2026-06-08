/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonManager {

    private final String FILE_NAME = "student.json";
    private ArrayList<Student> students;
    private Gson gson;

    public JsonManager() {

        gson = new GsonBuilder().setPrettyPrinting().create();
        students = loadStudents();
    }

 
    public ArrayList<Student> getStudents() {
        return students;
    }

 
    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
    }

    
    public void saveStudents() {

        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }


    public ArrayList<Student> loadStudents() {

        try (Reader reader = new FileReader(FILE_NAME)) {

            Type type = new TypeToken<ArrayList<Student>>() {}.getType();
            ArrayList<Student> list = gson.fromJson(reader, type);

            return list != null ? list : new ArrayList<>();

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
