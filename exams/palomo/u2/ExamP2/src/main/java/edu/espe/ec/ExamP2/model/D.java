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
public class D extends A{
    private List<E> aggregatedElements; 
    private List<F> composedParts;      

    public D(String name) {
        super(name);
        this.aggregatedElements = new ArrayList<>();
        this.composedParts = new ArrayList<>();
    }

    public boolean addAggregation(E element) {
        if (aggregatedElements.size() < 4) {
            aggregatedElements.add(element);
            return true;
        }
        return false;
    }

    public void createComposedPart(String fId) {
        composedParts.add(new F(fId));
    }

    public List<E> getAggregatedElements() {
        return aggregatedElements;
    }

    public List<F> getComposedParts() {
        return composedParts;
    }
}
