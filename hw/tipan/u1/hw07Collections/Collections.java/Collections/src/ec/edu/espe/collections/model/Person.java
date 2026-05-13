/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ronald Tipan <The-Softwarrios at ESPE>
 */
public class Person {
    private int id;
    private String name;
    private LocalDate bornOnDate;
    private boolean alive;

    public Person(int id, String name, LocalDate bornOnDate, boolean alive) {
        this.id = id;
        this.name = name;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
        
    }
    public int computoAgeInYears() {
    LocalDate currentDate = LocalDate.now();
    int age = Period.between(bornOnDate, currentDate).getYears();
    return age;
}
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", bornOnDate=" + bornOnDate + ", alive=" + alive + '}';
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
    
    
}


