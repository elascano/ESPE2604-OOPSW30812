/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
package ec.edu.espe.educativeapp.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // SAVE STUDENT CSV
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

    // SAVE TEACHER CSV
    public static void saveTeacherCSV(Teacher teacher) {

        try (FileWriter writer = new FileWriter("teachers.csv", true)) {

            writer.append(
                    teacher.getId() + ","
                    + teacher.getName() + ","
                    + teacher.getCareer() + "\n"
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // READ STUDENTS CSV
    public static List<Student> readStudentsCSV() {

        List<Student> students = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("students.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String data[] = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String course = data[2];

                Student student = new Student(id, name, course);

                students.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    // READ TEACHERS CSV
    public static List<Teacher> readTeachersCSV() {

        List<Teacher> teachers = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("teachers.csv"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String data[] = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String career = data[2];

                Teacher teacher = new Teacher(id, name, career);

                teachers.add(teacher);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    // SAVE STUDENT JSON
    public static void saveStudentJSON(Student student) {

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Student>>() {
        }.getType();

        List<Student> students = new ArrayList<>();

        File file = new File("students.json");

        try {

            if (file.exists()) {

                FileReader reader = new FileReader(file);

                students = gson.fromJson(reader, listType);

                reader.close();

                if (students == null) {
                    students = new ArrayList<>();
                }
            }

            students.add(student);

            FileWriter writer = new FileWriter(file);

            gson.toJson(students, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // SAVE TEACHER JSON
    public static void saveTeacherJSON(Teacher teacher) {

        Gson gson = new Gson();

        Type listType = new TypeToken<List<Teacher>>() {
        }.getType();

        List<Teacher> teachers = new ArrayList<>();

        File file = new File("teachers.json");

        try {

            if (file.exists()) {

                FileReader reader = new FileReader(file);

                teachers = gson.fromJson(reader, listType);

                reader.close();

                if (teachers == null) {
                    teachers = new ArrayList<>();
                }
            }

            teachers.add(teacher);

            FileWriter writer = new FileWriter(file);

            gson.toJson(teachers, writer);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // READ STUDENTS JSON
    public static List<Student> readStudentsJSON() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("students.json")) {

            Type listType = new TypeToken<List<Student>>() {
            }.getType();

            List<Student> students =
                    gson.fromJson(reader, listType);

            if (students == null) {
                return new ArrayList<>();
            }

            return students;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    // READ TEACHERS JSON
    public static List<Teacher> readTeachersJSON() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("teachers.json")) {

            Type listType = new TypeToken<List<Teacher>>() {
            }.getType();

            List<Teacher> teachers =
                    gson.fromJson(reader, listType);

            if (teachers == null) {
                return new ArrayList<>();
            }

            return teachers;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}