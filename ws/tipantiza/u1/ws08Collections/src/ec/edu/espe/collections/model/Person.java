/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections.model;
import java.time.LocalDate;
import java.time.Period;


/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class Person {
    
     private int id;
    private String fullName;
    private LocalDate bornOnDate;
    private boolean alive;
    
    public int computeAgeInYears(){
        int age;
        LocalDate currentDate = LocalDate.now();
        
        age = Period.between(bornOnDate, currentDate).getYears();
        return age;
    }
    

    @Override
    public String toString() {
        String isAlive;
        if(alive){
            isAlive = "YES";
        }else{
            isAlive = "NO";
        }
        return "Person " + id + " --> Name:" + fullName + ", BirthDate:" + bornOnDate + ", alive:" + isAlive + " <--";
    }
    
    

    public Person(int id, String fullName, LocalDate bornOnDatte, boolean alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDatte;
        this.alive = alive;
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

    public LocalDate getBornOnDatte() {
        return bornOnDate;
    }

    public void setBornOnDatte(LocalDate bornOnDatte) {
        this.bornOnDate = bornOnDatte;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
}
