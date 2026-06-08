package ec.edu.espe.shoppingstore.model;

import java.util.ArrayList;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Customer {
    
    private int id;
    private String firstName;
    private String lastName;
    private String typeOfClient;
    private String gender;
    private float moneySpend;
    private int age;
    private ArrayList<String> hobbies;

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", typeOfClient=" + typeOfClient + ", gender=" + gender + ", moneySpend=" + moneySpend + ", age=" + age + ", hobbies=" + hobbies + '}';
    }

    public Customer(int id, String firstName, String lastName, String typeOfClient, String gender, float moneySpend, int age, ArrayList<String> hobbies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfClient = typeOfClient;
        this.gender = gender;
        this.moneySpend = moneySpend;
        this.age = age;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTypeOfClient() {
        return typeOfClient;
    }

    public void setTypeOfClient(String typeOfClient) {
        this.typeOfClient = typeOfClient;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getMoneySpend() {
        return moneySpend;
    }

    public void setMoneySpend(float moneySpend) {
        this.moneySpend = moneySpend;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        this.hobbies = hobbies;
    }
}
