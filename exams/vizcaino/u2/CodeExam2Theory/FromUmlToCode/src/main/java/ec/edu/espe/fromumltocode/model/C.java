/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.fromumltocode.model;
import java.util.List;
/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */


public class C extends A {
    private List<E> eList;

    public C(String name, List<E> eList) {
        super(name);
        this.eList = eList;
    }

    @Override
    public void showInfo() {
        System.out.println("C: " + name);
        System.out.println("E count: " + eList.size());
    }
}
