/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.ExamP2.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class B extends A{
    private List<H> associatedHandlers; 

    public B(String name) {
        super(name);
        this.associatedHandlers = new ArrayList<>();
    }

    public void addAssociation(H handler) {
        this.associatedHandlers.add(handler);
    }

    public List<H> getAssociatedHandlers() {
        return associatedHandlers;
    }
}
