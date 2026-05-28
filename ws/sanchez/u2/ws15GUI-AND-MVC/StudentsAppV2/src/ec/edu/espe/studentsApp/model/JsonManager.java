/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.studentsApp.model;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */

public class JsonManager {
    private static final String FILE_NAME = "students.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveStudents(ArrayList<Student> students) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            System.err.println("Error saving: " + e.getMessage());
        }
    }

    public static ArrayList<Student> readStudents() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type type = new TypeToken<ArrayList<Student>>(){}.getType();
            ArrayList<Student> students = gson.fromJson(reader, type);
            return students != null ? students : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}