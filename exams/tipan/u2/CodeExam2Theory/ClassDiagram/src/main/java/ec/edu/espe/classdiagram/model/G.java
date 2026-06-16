/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.classdiagram.model;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
    public class G implements H {

    private J j;

    public G(J j) {
        this.j = j;
    }

    @Override
    public void ejecutar() {
        System.out.println("G implementa H");
        j.mostrar();
    }
}

