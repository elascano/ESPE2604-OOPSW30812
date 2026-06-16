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

public class D extends A {

    private List<E> eList;
    private F f; 

    public D(String name, List<E> eList) {
        super(name);
        this.eList = eList;
        this.f = new F("F inside D");
    }

    @Override
    public void showInfo() {
        System.out.println("D: " + name);
        System.out.println("E size: " + eList.size());
        f.showInfo();
    }

    public F getF() {
        return f;
    }
}