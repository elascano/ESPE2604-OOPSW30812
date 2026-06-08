package ec.edu.espe.collections.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Edison Lascano, Object Masters, @ESPE
 */
public class Person {

    private int id;
    private String fullName;
    private LocalDate bornOnDate;
    private boolean alive;

    public int computeAgeInYears(){
        int age;
        LocalDate currentDate = LocalDate.now();

        age = Period.between(bornOnDate,currentDate).getYears();
        return age;
    }
    
    @Override
    public String toString() {
        String isAlive;
        if (alive) {
            isAlive = "YES";
        } else {
            isAlive = "NO";
        }
        return "Person " + id + " --> name:" + fullName + ", birthDate:" + bornOnDate + ", alive:" + isAlive + "<--";
    }

    public Person(int id, String fullName, LocalDate bornOnDate, boolean alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
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
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the bornOnDate
     */
    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
