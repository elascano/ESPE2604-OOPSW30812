/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.Exam2.controller;
import ec.edu.espe.Exam2.model.A;
import ec.edu.espe.Exam2.model.B;
import ec.edu.espe.Exam2.model.C;
import ec.edu.espe.Exam2.model.D;
import ec.edu.espe.Exam2.model.E;
import ec.edu.espe.Exam2.model.G;
import ec.edu.espe.Exam2.model.J;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */

public class DiagramController {

    public void runDemonstration() {
        A mainA = new A("A-Principal");
        A subA1 = new A("A-Hijo-1");
        mainA.addSubA(subA1);
        System.out.println(mainA);

        G objectG = new G("Objeto-G1");
        J objectJ = new J("Datos-Temporales-J");
        System.out.println(objectG);
        objectG.showRole();
        objectG.performActionWithJ(objectJ); 

        B objectB = new B("B-Subclase");
        objectB.addH(objectG); 
        System.out.println(objectB);

        E e1 = new E("E-Componente-1");
        E e2 = new E("E-Componente-2");

        C objectC = new C("C-Subclase");
        objectC.addE(e1);
        System.out.println(objectC);

        D objectD = new D("D-Subclase");
        objectD.addE(e2); 
        objectD.createAndAddF("F-Exclusivo-D"); 
        System.out.println(objectD);
    }
}
