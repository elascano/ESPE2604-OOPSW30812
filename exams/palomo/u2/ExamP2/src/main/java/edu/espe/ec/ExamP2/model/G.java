/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.espe.ec.ExamP2.model;

/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public class G implements H {
    @Override
    public void requestAction() {
        System.out.println("  [Clase G] Realizando la acción de la Interfaz H.");
    }

    public void useDependency(J dependencyJ) {
        System.out.println("  [Clase G] Accediendo a la dependencia:");
        System.out.println("  " + dependencyJ.getInfo());
    }
}
