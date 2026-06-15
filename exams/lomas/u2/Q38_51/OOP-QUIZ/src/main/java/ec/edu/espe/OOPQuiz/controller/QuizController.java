package ec.edu.espe.OOPQuiz.controller;

import ec.edu.espe.OOPQuiz.model.*;

public class QuizController {
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