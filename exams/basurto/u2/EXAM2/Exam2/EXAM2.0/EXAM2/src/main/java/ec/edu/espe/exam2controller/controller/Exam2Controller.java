package ec.edu.espe.exam2controller.controller;

import ec.edu.espe.exam2.model.*;
/**
 *
 * @author Esteban Basurto, CodeBreakers, @ESPE
 */
public class Exam2Controller {
    public void runSimulation() {
        A compositeA = new A();
        A partA = new A();
        compositeA.addSubPart(partA);

        B instanceB = new B();
        G instanceG = new G();
        instanceB.addElement(instanceG);

        C instanceC = new C();
        E instanceE1 = new E();
        instanceC.addElement(instanceE1);

        D instanceD = new D();
        E instanceE2 = new E();
        instanceD.addBoundedElement(instanceE2);

        J instanceJ = new J();
        instanceG.useJ(instanceJ);

        compositeA.display();
        instanceB.display();
        instanceC.display();
        instanceD.display();
    }
}