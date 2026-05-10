package ec.edu.espe.chikencoops.model;

import java.util.Date;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Chiken {
    private int id;
    private String name,color;
    private Date bornOnDate;
    private boolean isMolting;
    private int age;

    public Chiken(int id, String color, Date bornOnDate, boolean molting, int age) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Chiken(int id, String name, String color, Date bornOnDate, boolean isMolting, int age) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.isMolting = isMolting;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Chiken{" + "id=" + id + ", name=" + name + ", color=" + color + ", bornOnDate=" + bornOnDate + ", isMolting=" + isMolting + ", age=" + age + '}';
    }
    
    
    
}
