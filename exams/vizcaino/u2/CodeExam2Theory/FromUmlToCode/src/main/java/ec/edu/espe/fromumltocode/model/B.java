/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.fromumltocode.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */

public class B extends A implements H {

    public B(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("B executing H interface");
    }

    @Override
    public void showInfo() {
        System.out.println("B: " + name);
    }
}