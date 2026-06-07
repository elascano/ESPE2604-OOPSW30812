/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsystem.model.Student;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class StudentDAO {

    private final MongoCollection<Document> collection;

    public StudentDAO() {

        collection =
                MongoConnection
                        .getDatabase()
                        .getCollection("students");
    }

    public void save(Student student) {

        Document document = new Document();

        document.append("id", student.getId());
        document.append("firstName", student.getFirstName());
        document.append("lastName", student.getLastName());
        document.append("age", student.getAge());

        collection.insertOne(document);
    }

    public Student findById(String id) {

        Document document =
                collection.find(
                        Filters.eq("id", id))
                        .first();

        if (document == null) {
            return null;
        }

        Student student = new Student();

        student.setId(document.getString("id"));
        student.setFirstName(document.getString("firstName"));
        student.setLastName(document.getString("lastName"));
        student.setAge(document.getInteger("age"));

        return student;
    }

    public void delete(String id) {

        collection.deleteOne(
                Filters.eq("id", id));
    }
}