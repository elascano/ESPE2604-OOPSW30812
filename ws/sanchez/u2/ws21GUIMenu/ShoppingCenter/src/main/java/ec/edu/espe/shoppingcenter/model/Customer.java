/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
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
    
        @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", moneySpent=" + moneySpent + ", age=" + age + ", typeOfCustomer=" + typeOfCustomer + ", hobbies=" + hobbies + '}';
    }

    public Customer(int id, String firstName, String lastName, String gender, String typeOfCustomer, float moneySpent, int age, ArrayList<String> hobbies) {
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
    private int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    private void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    private String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    private String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the gender
     */
    private String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    private void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the moneySpent
     */
    private float getMoneySpent() {
        return moneySpent;
    }

    /**
     * @param moneySpent the moneySpent to set
     */
    private void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    /**
     * @return the age
     */
    private int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    private void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the typeOfCustomer
     */
    private String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    /**
     * @param typeOfCustomer the typeOfCustomer to set
     */
    private void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    /**
     * @return the hobbies
     */
    private ArrayList<String> getHobbies() {
        return hobbies;
    }

    /**
     * @param hobbies the hobbies to set
     */
    private void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
   
    
    
}
