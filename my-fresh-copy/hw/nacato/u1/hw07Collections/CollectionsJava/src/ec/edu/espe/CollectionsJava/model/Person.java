package ec.edu.espe.CollectionsJava.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Person {
        private int id;
        private String fullName;
        private LocalDate bornOnDate;
        private boolean alive;
        
    public int computeAge(){
        int age;
        LocalDate currentDate=LocalDate.now();
        age = Period.between(bornOnDate, currentDate).getYears();
        return age ;
    }

    @Override
    public String toString() {
        String isAlive;
        if(alive){
            isAlive="YES";
        }else{
            isAlive="NO";
        }
        return "Person{" + "id=" + id + ", fullName=" + fullName + ", bornOnDate=" + bornOnDate + ", alive=" + alive + '}';
    }
        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Person(int id, String fullName, LocalDate bornOnDate, boolean alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    } 
}