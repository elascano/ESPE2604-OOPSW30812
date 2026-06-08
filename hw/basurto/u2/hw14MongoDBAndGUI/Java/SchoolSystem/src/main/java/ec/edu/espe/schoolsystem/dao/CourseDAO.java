/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.schoolsystem.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.schoolsystem.model.Course;
import org.bson.Document;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class CourseDAO {

    private final MongoCollection<Document> collection;

    public CourseDAO() {

        collection =
                MongoConnection
                        .getDatabase()
                        .getCollection("courses");
    }

    public void save(Course course) {

        Document document = new Document();

        document.append("id", course.getId());
        document.append("name", course.getName());
        document.append("teacher", course.getTeacher());

        collection.insertOne(document);
    }

    public Course findById(String id) {

        Document document =
                collection.find(
                        Filters.eq("id", id))
                        .first();

        if(document == null){
            return null;
        }

        Course course = new Course();

        course.setId(document.getString("id"));
        course.setName(document.getString("name"));
        course.setTeacher(document.getString("teacher"));

        return course;
    }

    public void delete(String id){

        collection.deleteOne(
                Filters.eq("id", id));
    }
}