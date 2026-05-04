/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.educativeapp.model;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class FileManager {

    public static void saveStudentCSV(Student student) {
        try (FileWriter writer = new FileWriter("students.csv", true)) {

            writer.append(
                    student.getId() + ","
                    + student.getName() + ","
                    + student.getCourse() + "\n"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTeacherCSV(Teacher teacher) {
        try (FileWriter writer = new FileWriter("teacher.csv", true)) {

            writer.append(
                    teacher.getId() + ","
                    + teacher.getName() + ","
                    + teacher.getCareer() + "\n"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudentJSON(Student student) {

        Gson gson = new Gson();
        List<Student> students = new ArrayList<>();

        try {
            File file = new File("students.json");

            if (file.exists()) {
                FileReader reader = new FileReader(file);

                Type listType = new TypeToken<List<Student>>() {
                }.getType();
                students = gson.fromJson(reader, listType);

                reader.close();

                if (students == null) {
                    students = new ArrayList<>();
                }
            }

            students.add(student);

            FileWriter writer = new FileWriter("students.json");

            gson.toJson(students, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTeacherJSON(Teacher teacher) {

        Gson gson = new Gson();
        List<Teacher> teachers = new ArrayList<>();

        try {
            File file = new File("teachers.json");

            if (file.exists()) {
                FileReader reader = new FileReader(file);

                Type listType = new TypeToken<List<Teacher>>() {
                }.getType();
                teachers = gson.fromJson(reader, listType);

                reader.close();

                if (teachers == null) {
                    teachers = new ArrayList<>();
                }
            }

            teachers.add(teacher);

            FileWriter writer = new FileWriter("teachers.json");

            gson.toJson(teachers, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
