/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;


/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private float moneySpent;
    private int age;
    private String typeOfCustomer;
    private ArrayList<String> hobbies;
    
    public Customer(int id, String firstName, String lastName, String gender, float moneySpent, int age, String typeOfCustomer, ArrayList<String> hobbies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.moneySpent = moneySpent;
        this.age = age;
        this.typeOfCustomer = typeOfCustomer;
        this.hobbies = hobbies;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * @return the typeOfCustomer
     */
    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    /**
     * @param typeOfCustomer the typeOfCustomer to set
     */
    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
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
    
    
    
}
