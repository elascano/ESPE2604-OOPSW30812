package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;

/**
 *
 * @author Cristian 
 */
public class Customer {
    private int id;
    private String firsName;
    private String lastName;
    private String gender;
    private float moneySpent;
    private int age;
    private String typeOfCustomer;
    private ArrayList<String> hibbies;

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
     * @return the firsName
     */
    public String getFirsName() {
        return firsName;
    }

    /**
     * @param firsName the firsName to set
     */
    public void setFirsName(String firsName) {
        this.firsName = firsName;
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
     * @return the hibbies
     */
    public ArrayList<String> getHibbies() {
        return hibbies;
    }

    /**
     * @param hibbies the hibbies to set
     */
    public void setHibbies(ArrayList<String> hibbies) {
        this.hibbies = hibbies;
    }
    
}


