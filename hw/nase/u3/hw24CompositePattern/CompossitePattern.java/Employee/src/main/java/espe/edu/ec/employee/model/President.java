/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espe.edu.ec.employee.model;

/**
 *
 * @author Jennyfer Nase
 */
public class President extends Supervisor {
    private static President president = new President();

    private President(String aName) {
        this();
        this.name = aName;
    }

    private President() {
        super();
        this.title = "President";
    }

    @Override
    public void stateName() {
        super.stateName();
    }

    public static President getPresident(String aName) {
        president.name = aName;
        return president;
    }
}
