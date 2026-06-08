
package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private float moneySpent;
    private int age;
    private String typedOfCustomer;
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
     * @return the typedOfCustomer
     */
    public String getTypedOfCustomer() {
        return typedOfCustomer;
    }

    /**
     * @param typedOfCustomer the typedOfCustomer to set
     */
    public void setTypedOfCustomer(String typedOfCustomer) {
        this.typedOfCustomer = typedOfCustomer;
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
