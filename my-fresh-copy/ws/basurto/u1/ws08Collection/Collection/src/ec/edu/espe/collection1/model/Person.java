/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.time.LocalDate;

/**
 *
 * @author Jennyfer Nase
 */
public class Person {
   private int id;
   private String fullName;
   private LocalDate bornOnDate;
   private boolean alive; 
    
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fullName=" + fullName + ", bornOnDate=" + bornOnDate + ", alive=" + alive + '}';
    }

    public Person(int id, String fullName, LocalDate bornOnDate, boolean alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }
   

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the bornOnDate
     */
    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public int computeAgeInYears() {
        LocalDate now = LocalDate.now();
        return java.time.Period.between(bornOnDate, now).getYears();
    }
   
}
