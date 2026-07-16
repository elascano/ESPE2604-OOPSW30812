/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.compositepattern.model;

public abstract class Employee {

    protected String name;
    protected String title;

    public Employee() {
    }

    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public void stateName() {
        System.out.println(title + " " + name);
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " " + name;
    }

}