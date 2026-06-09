package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;

/**
 *
 * @author Cristian 
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
        return firstName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firsName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", moneySpent=" + moneySpent + ", age=" + age + ", typeOfCustomer=" + typeOfCustomer + ", hobbies=" + hobbies + '}';
    }
     public Customer(int id, String firstName, String lastName, String typeOfCustomer, String gender, float moneySpent, int age, ArrayList<String> hobbies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfCustomer = typeOfCustomer;
        this.gender = gender;
        this.moneySpent = moneySpent;
        this.age = age;
        this.hobbies = hobbies;
    }

    /**
     * @param firsName the firsName to set
     */
    public void setFirsName(String firsName) {
        this.firstName = firsName;
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
        return hobbies;
    }

    /**
     * @param hibbies the hibbies to set
     */
    public void setHibbies(ArrayList<String> hibbies) {
        this.hobbies = hibbies;
    }
    
}


