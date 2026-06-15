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
public class A {
    protected String name;
    protected List<A> compositeSubParts; 

    public A(String name) {
        this.name = name;
        this.compositeSubParts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSubPart(A child) {
        this.compositeSubParts.add(child);
    }

    public List<A> getCompositeSubParts() {
        return compositeSubParts;
    }
}
