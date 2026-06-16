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

public class C extends A {

    private List<E> elementosE;

    public C() {
        elementosE = new ArrayList<>();
    }

    public void agregarE(E e) {

        if (elementosE.size() < 3) {
            elementosE.add(e);
        }
    }

    @Override
    public String toString() {
        return "C -> E asociados: " + elementosE.size();
    }
}

