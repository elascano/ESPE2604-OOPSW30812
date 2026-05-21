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

    private static final String FILE_NAME = "student.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveStudents(ArrayList<Student> students) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(students, writer);
            System.out.println("\nData saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static ArrayList<Student> readStudents() {

        try (FileReader reader = new FileReader(FILE_NAME)) {

            Type type = new TypeToken<ArrayList<Student>>() {}.getType();
            return gson.fromJson(reader, type);

        } catch (IOException e) {
            System.out.println("No file found or error reading file.");
            return new ArrayList<>();
        }
    }
}
