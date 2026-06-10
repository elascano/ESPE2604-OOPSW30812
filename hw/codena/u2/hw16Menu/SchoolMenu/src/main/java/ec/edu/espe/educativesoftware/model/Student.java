package ec.edu.espe.educativesoftware.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Student extends User{
    
    private String learningType;
    private String learningPace;
    private LocalDate bornOnDate;
    private float averageGrade;
    private List<Course> courses;


    public Student() {
    }

    public Student( 
            String id, 
            String name, 
            String email, 
            String password,
            LocalDate bornOnDate,
            String learningType, 
            String learningPace
            ) {
        
        super(id, name, email, password, Role.STUDENT);
        
        this.learningType = learningType;
        this.learningPace = learningPace;
        this.bornOnDate = bornOnDate;
        this.averageGrade = 0;
        this.courses = new ArrayList<>();
    }

    public String getLearningType() {
        return learningType;
    }

    public void setLearningType(String learningType) {
        this.learningType = learningType;
    }

    public String getLearningPace() {
        return learningPace;
    }

    public void setLearningPace(String learningPace) {
        this.learningPace = learningPace;
    }

    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(float averageGrade) {
        this.averageGrade = averageGrade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    
}
