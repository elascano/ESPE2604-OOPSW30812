/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class President extends Supervisor {
    private static President president;

    private President(String aName) {
        this();
        name = aName;
    }

    private President() {
        super();
        title = "President";
    }

    public void stateName() {
        super.stateName();
    }

    public static President getPresident(String aName) {
        if (president == null) {
            president = new President();
        }
        president.name = aName;
        return president;
    }
}
