package ec.edu.espe.controller;

import ec.edu.espe.model.Grade;
import ec.edu.espe.model.JsonManager;
import ec.edu.espe.model.Student;
import java.util.ArrayList;

public class StudentController {

    private ArrayList<Student> students;
    private ArrayList<Grade> grades;

    public StudentController() {
        this.students = JsonManager.loadStudents();
        this.grades = JsonManager.loadGrades();
    }

    public void registerStudent(String id, String firstName, String lastName, String phoneNumber) {
        Student newStudent = new Student(id, firstName, lastName, phoneNumber);
        students.add(newStudent);
        JsonManager.saveStudents(students);
    }

    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean addGradesToStudent(String id, ArrayList<Double> newValues) {
        Student student = findStudentById(id);
        if (student != null) {
            try {

                for (double val : newValues) {
                    if (val < 0 || val > 20) {
                        throw new IllegalArgumentException("All grades must be between 0 and 20.");
                    }
                }

                for (double val : newValues) {
                    Grade newGrade = new Grade(id, val);
                    grades.add(newGrade);
                }

                JsonManager.saveGrades(grades);
                return true;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public ArrayList<Double> getGradesByStudent(String studentId) {
        ArrayList<Double> studentGrades = new ArrayList<>();
        for (Grade grade : grades) {
            if (grade.getStudentId().equalsIgnoreCase(studentId)) {
                studentGrades.add(grade.getValue());
            }
        }
        return studentGrades;
    }

    public double calculateAverage(String studentId) {
        ArrayList<Double> studentGrades = getGradesByStudent(studentId);
        if (studentGrades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (double val : studentGrades) {
            sum += val;
        }
        return sum / studentGrades.size();
    }

    public ArrayList<Student> getAllStudents() {
        this.students = JsonManager.loadStudents();
        this.grades = JsonManager.loadGrades();
        return students;
    }
}
