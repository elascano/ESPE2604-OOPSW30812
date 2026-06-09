/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppignCenter.model;
import java.util.ArrayList;
/**
 *
 * @author Cristian
 */
public class Customer {
    private int id;
    private String firtsName;
    private String lastName;
    private String gender;
    private float moneySpent;
    private int age;
    private String typeCustomer;    
    private ArrayList<String>hobbies;

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
     * @return the firtsName
     */
    public String getFirtsName() {
        return firtsName;
    }

    /**
     * @param firtsName the firtsName to set
     */
    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the moneySpent
     */
    public float getMoneySpent() {
        return moneySpent;
    }

    /**
     * @param moneySpent the moneySpent to set
     */
    public void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the typeCustomer
     */
    public String getTypeCustomer() {
        return typeCustomer;
    }

    /**
     * @param typeCustomer the typeCustomer to set
     */
    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    /**
     * @return the hobbies
     */
    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firtsName=" + firtsName + ", lastName=" + lastName + ", gender=" + gender + ", moneySpent=" + moneySpent + ", age=" + age + ", typeCustomer=" + typeCustomer + ", hobbies=" + hobbies + '}';
    }
    
    public Customer(int id, String firtsName, String lastName, String gender, float moneySpent, int age, String typeCustomer, ArrayList<String> hobbies) {
        this.id = id;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.gender = gender;
        this.moneySpent = moneySpent;
        this.age = age;
        this.typeCustomer = typeCustomer;
        this.hobbies = hobbies;
    }
    
}
