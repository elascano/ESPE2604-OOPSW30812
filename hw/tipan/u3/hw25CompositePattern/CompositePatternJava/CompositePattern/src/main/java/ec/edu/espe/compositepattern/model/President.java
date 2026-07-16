/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

public class President extends Supervisor {

    private static President president;

    private President(String name) {
        super(name, "President");
    }

    public static President getPresident(String name) {

        if (president == null) {
            president = new President(name);
        } else {
            president.name = name;
        }

        return president;
    }

    @Override
    public void stateName() {
        super.stateName();
    }

}