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

public class B extends A {

    private List<H> interfaces;

    public B() {
        interfaces = new ArrayList<>();
    }

    public void agregarH(H h) {
        interfaces.add(h);
    }

    @Override
    public String toString() {
        return "B -> Objetos H: " + interfaces.size();
    }
}
