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

public class A {

    private List<A> hijos;

    public A() {
        hijos = new ArrayList<>();
    }

    public void agregarHijo(A hijo) {
        hijos.add(hijo);
    }

    public int getCantidadHijos() {
        return hijos.size();
    }

    @Override
    public String toString() {
        return "A -> Hijos: " + hijos.size();
    }
}
