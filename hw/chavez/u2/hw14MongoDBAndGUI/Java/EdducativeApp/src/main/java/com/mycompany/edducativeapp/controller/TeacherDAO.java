/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edducativeapp.controller;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.edducativeapp.model.Teacher;
/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class TeacherDAO {
    private MongoCollection<Document> collection;
    
    public TeacherDAO() {
        MongoDatabase database = MongoDBConnection.getInstance().getDatabase();
        this.collection = database.getCollection("teachers");
    }
    
    public boolean createTeacher(Teacher teacher) {
        try {
            Document doc = teacher.toDocument();
            collection.insertOne(doc);
            teacher.setId(doc.getObjectId("_id").toString());
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear profesor: " + e.getMessage());
            return false;
        }
    }
    
    public Teacher findTeacherByEmail(String email) {
        try {
            Document doc = collection.find(Filters.eq("email", email)).first();
            if (doc != null) {
                return Teacher.fromDocument(doc);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesor: " + e.getMessage());
        }
        return null;
    }
    
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            for (Document doc : collection.find()) {
                teachers.add(Teacher.fromDocument(doc));
            }
        } catch (Exception e) {
            System.err.println("Error al obtener profesores: " + e.getMessage());
        }
        return teachers;
    }
    
    public boolean updateTeacher(Teacher teacher) {
        try {
            Document doc = teacher.toDocument();
            collection.replaceOne(Filters.eq("_id", new org.bson.types.ObjectId(teacher.getId())), doc);
            return true;
        } catch (Exception e) {
            System.err.println("Error al actualizar profesor: " + e.getMessage());
            return false;
        }
    }
    
    public boolean deleteTeacher(String id) {
        try {
            collection.deleteOne(Filters.eq("_id", new org.bson.types.ObjectId(id)));
            return true;
        } catch (Exception e) {
            System.err.println("Error al eliminar profesor: " + e.getMessage());
            return false;
        }
    }
}
    

