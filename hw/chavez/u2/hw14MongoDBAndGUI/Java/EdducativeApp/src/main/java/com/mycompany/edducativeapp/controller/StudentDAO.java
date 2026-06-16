/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.controller;
import com.mycompany.edducativeapp.model.Student;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class StudentDAO {
    private MongoCollection<Document> collection;
    
    public StudentDAO() {
        MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
        this.collection = database.getCollection("students");
    }
    
    public boolean createStudent(Student student) {
        try {
            Document doc = student.toDocument();
            collection.insertOne(doc);
            student.setId(doc.getObjectId("_id").toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear estudiante: " + e.getMessage());
            return false;
        }
    }
    
    public Student findStudentByEmail(String email) {
        try {
            Document doc = collection.find(Filters.eq("email", email)).first();
            if (doc != null) {
                return Student.fromDocument(doc);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar estudiante: " + e.getMessage());
        }
        return null;
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            for (Document doc : collection.find()) {
                students.add(Student.fromDocument(doc));
            }
        } catch (Exception e) {
            System.err.println("Error al obtener estudiantes: " + e.getMessage());
        }
        return students;
    }
    
    public boolean updateStudent(Student student) {
        try {
            Document doc = student.toDocument();
            collection.replaceOne(Filters.eq("_id", new org.bson.types.ObjectId(student.getId())), doc);
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteStudent(String id) {
        try {
            collection.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }
}
    
    

