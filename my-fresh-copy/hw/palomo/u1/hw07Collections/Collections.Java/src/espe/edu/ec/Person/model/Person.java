/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.Person.model;
import java.time.LocalDate;
import java.time.Period;
/**
 *
 * @author Cristian
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