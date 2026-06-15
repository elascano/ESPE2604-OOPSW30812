/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.examp2.edu.espe.ec.ExamP2.view;

/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
package ec.espe.edu.examp2.view;

import java.util.List;
import examp2.model.*;

public class ConsoleView {

    public void printHeader() {
        System.out.println("========================================================");
        System.out.println("       DEMOSTRACIÓN DE LA ARQUITECTURA EN NETBEANS MVC ");
        System.out.println("========================================================\n");
    }

    public void printSection(String sectionName) {
        System.out.println("--- " + sectionName + " ---");
    }

    public void displayClassA(A objA) {
        System.out.println("[Clase A (Base)] " + objA.getName());
        List<A> subParts = objA.getCompositeSubParts();
        if (!subParts.isEmpty()) {
            System.out.println("  -> Sub-partes de Composición Reflexiva de " + objA.getName() + ":");
            for (A child : subParts) {
                System.out.println("     [Clase A] " + child.getName());
            }
        }
        System.out.println();
    }

    public void displayClassB(B objB) {
        System.out.println("[Clase B (Especialización de A)] " + objB.getName());
        System.out.println("  -> Enlaces asociados 'r' (" + objB.getAssociatedHandlers().size() + " elementos):");
        for (H handler : objB.getAssociatedHandlers()) {
            handler.requestAction();
        }
        System.out.println();
    }

    public void displayClassC(C objC) {
        System.out.println("[Clase C (Especialización de A)] " + objC.getName());
        System.out.println("  -> Elementos E agregados (" + objC.getAggregatedElements().size() + "/3):");
        for (E elem : objC.getAggregatedElements()) {
            System.out.println("  [Clase E] " + elem.getName());
        }
        System.out.println();
    }

    public void displayClassD(D objD) {
        System.out.println("[Clase D (Especialización de A)] " + objD.getName());
        System.out.println("  -> Elementos E agregados (" + objD.getAggregatedElements().size() + "/4):");
        for (E elem : objD.getAggregatedElements()) {
            System.out.println("  [Clase E] " + elem.getName());
        }
        System.out.println("  -> Componentes F compuestos:");
        for (F part : objD.getComposedParts()) {
            System.out.println("    - [Clase F] ID del Componente: " + part.getId());
        }
        System.out.println();
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
