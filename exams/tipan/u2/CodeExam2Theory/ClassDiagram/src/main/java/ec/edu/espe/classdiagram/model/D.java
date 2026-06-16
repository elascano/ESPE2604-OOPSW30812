/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.classdiagram.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */


public class D extends A {

    private List<E> elementosE;
    private List<F> elementosF;

    public D() {
        elementosE = new ArrayList<>();
        elementosF = new ArrayList<>();
    }

    public void agregarE(E e) {

        if (elementosE.size() < 4) {
            elementosE.add(e);
        }
    }

    public void agregarF(F f) {
        elementosF.add(f);
    }

    @Override
    public String toString() {
        return "D -> E: " + elementosE.size()
                + " | F: " + elementosF.size();
    }
}

