/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickencoops.model;

import java.util.Date;

/**
 *
 * @author Cristian, Error 404, @ ESPE
 */
public class Chicken {
    private int id;
    private String name;
    private String color;
    private Date bornOnDate;
    private int age;
    private boolean isMolting;

    // Constructor
    public Chicken(int id, String name, String color, Date bornOnDate, int age, boolean isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.age = age;
        this.isMolting = isMolting;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getColor() { return color; }
    public Date getBornOnDate() { return bornOnDate; }
    public int getAge() { return age; }
    public boolean isIsMolting() { return isMolting; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setColor(String color) { this.color = color; }
    public void setBornOnDate(Date bornOnDate) { this.bornOnDate = bornOnDate; }
    public void setAge(int age) { this.age = age; }
    public void setIsMolting(boolean isMolting) { this.isMolting = isMolting; }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color +
               ", bornOnDate=" + bornOnDate + ", age=" + age + ", isMolting=" + isMolting + '}';
    }
}
