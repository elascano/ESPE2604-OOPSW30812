/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.ede.espe.Exam.model;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
import java.util.ArrayList;
import java.util.List;

public class C extends A {

    private List<E> eList = new ArrayList<>();

    public void addE(E e) {
        eList.add(e);
    }

    @Override
    public String toString() {
        return "C " + eList;
    }
}
