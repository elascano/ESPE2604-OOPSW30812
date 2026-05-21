package ec.edu.espe.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class JsonManager {

    private static final String STUDENTS_FILE = "students.json";
    private static final String GRADES_FILE = "grades.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveStudents(ArrayList<Student> students) {
        try (FileWriter writer = new FileWriter(STUDENTS_FILE)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents() {
        if (!Files.exists(Paths.get(STUDENTS_FILE))) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(STUDENTS_FILE)) {
            Student[] array = gson.fromJson(reader, Student[].class);
            ArrayList<Student> list = new ArrayList<>();
            if (array != null) {
                Collections.addAll(list, array);
            }
            return list;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void saveGrades(ArrayList<Grade> grades) {
        try (FileWriter writer = new FileWriter(GRADES_FILE)) {
            gson.toJson(grades, writer);
        } catch (IOException e) {
            System.out.println("Error saving grades: " + e.getMessage());
        }
    }

    public static ArrayList<Grade> loadGrades() {
        if (!Files.exists(Paths.get(GRADES_FILE))) {
            return new ArrayList<>();
        }
        try (FileReader reader = new FileReader(GRADES_FILE)) {
            Grade[] array = gson.fromJson(reader, Grade[].class);
            ArrayList<Grade> list = new ArrayList<>();
            if (array != null) {
                Collections.addAll(list, array);
            }
            return list;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
