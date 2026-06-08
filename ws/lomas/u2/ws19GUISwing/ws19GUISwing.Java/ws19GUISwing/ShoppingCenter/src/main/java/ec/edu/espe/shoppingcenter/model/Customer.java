
package ec.edu.espe.shoppingcenter.model;

import java.util.ArrayList;

/**
 *
 * @author LABS-ESPE
 */
public class Customer {

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public float getMoneySpent() {
        return moneySpent;
    }

    public int getAge() {
        return age;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", moneySpent=" + moneySpent + ", age=" + age + ", typeOfCustomer=" + typeOfCustomer + ", hobbies=" + hobbies + '}';
    }
    int id;
    String firstName;
    String lastName;
    String gender;
    float moneySpent;
    int age;
    String typeOfCustomer;
    ArrayList <String> hobbies;

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
    
   
    
    
    
    
    
}
