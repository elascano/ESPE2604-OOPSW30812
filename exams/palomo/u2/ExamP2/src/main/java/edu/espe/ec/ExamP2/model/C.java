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
public class C extends A {
    private List<E> aggregatedElements; 

    public C(String name) {
        super(name);
        this.aggregatedElements = new ArrayList<>();
    }

    public boolean addAggregation(E element) {
        if (aggregatedElements.size() < 3) {
            aggregatedElements.add(element);
            return true;
        }
        return false;
    }

    public List<E> getAggregatedElements() {
        return aggregatedElements;
    }
}
