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

public class B extends A {
    private List<H> r; 

    public B(String id) {
        super(id);
        this.r = new ArrayList<>();
    }

    public void addH(G hObject) {
        if (hObject != null) {
            this.r.add(hObject);
        }
    }

    @Override
    public String toString() {
        return "Clase B (Hereda de A) [id=" + getId() + ", Asociaciones 'r' con H=" + r.size() + "]";
    }
}