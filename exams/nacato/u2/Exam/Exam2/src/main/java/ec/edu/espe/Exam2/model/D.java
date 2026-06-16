/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Exam2.model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class D extends A {
    private List<E> eList; 
    private List<F> fList; 

    public D(String id) {
        super(id);
        this.eList = new ArrayList<>();
        this.fList = new ArrayList<>();
    }

    public boolean addE(E eObject) {
        if (eList.size() < 5 && eObject != null) {
            eList.add(eObject);
            return true;
        }
        return false; 
    }

    public void createAndAddF(String codeF) {
        F newF = new F(codeF);
        this.fList.add(newF);
    }

    @Override
    public String toString() {
        return "Clase D (Hereda de A) [id=" + getId() + 
               ", Agregaciones con E=" + eList.size() + "/5" + 
               ", Composiciones con F=" + fList.size() + "]";
    }
}