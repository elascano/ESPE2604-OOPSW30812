/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Exam2.model;
import ec.edu.espe.Exam2.model.H;
import ec.edu.espe.Exam2.model.J;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class G implements H {
    private String nameG;

    public G(String nameG) {
        this.nameG = nameG;
    }

    @Override
    public void showRole() {
        System.out.println("-> Ejecutando showRole() en Clase G: " + nameG + " implementando Interfaz H.");
    }

    public void performActionWithJ(J jObject) {
        System.out.println("-> Clase G usando temporalmente a J: " + jObject.toString());
    }

    @Override
    public String toString() {
        return "Clase G [nameG=" + nameG + " - Implementa H]";
    }
}