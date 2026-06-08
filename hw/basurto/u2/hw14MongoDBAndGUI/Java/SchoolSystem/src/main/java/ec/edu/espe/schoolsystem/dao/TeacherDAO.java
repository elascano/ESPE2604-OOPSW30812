/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsystem.model.Teacher;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class TeacherDAO {

    private final MongoCollection<Document> collection;

    public TeacherDAO() {

        collection =
                MongoConnection
                        .getDatabase()
                        .getCollection("teachers");
    }

    public void save(Teacher teacher) {

        Document document = new Document();

        document.append("id", teacher.getId());
        document.append("name", teacher.getName());
        document.append("subject", teacher.getSubject());

        collection.insertOne(document);
    }

    public Teacher findById(String id) {

        Document document =
                collection.find(
                        Filters.eq("id", id))
                        .first();

        if(document == null){
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId(document.getString("id"));
        teacher.setName(document.getString("name"));
        teacher.setSubject(document.getString("subject"));

        return teacher;
    }

    public void delete(String id){

        collection.deleteOne(
                Filters.eq("id", id));
    }
}