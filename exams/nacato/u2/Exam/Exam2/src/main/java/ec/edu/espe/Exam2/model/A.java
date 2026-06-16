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

public class A {
    private String id;
    private List<A> subA; 

    public A(String id) {
        this.id = id;
        this.subA = new ArrayList<>();
    }

    public void addSubA(A a) {
        if (a != null) {
            this.subA.add(a);
        }
    }

    public String getId() {
        return id;
    }

    public List<A> getSubA() {
        return subA;
    }

    @Override
    public String toString() {
        return "Clase A [id=" + id + ", Hijos compuestos A=" + subA.size() + "]";
    }
}
