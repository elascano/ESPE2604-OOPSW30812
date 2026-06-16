/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.fromumltocode.controller;

/**
 *
 * @author Adrian Vizcaino <The-Softwarrios at ESPE>
 */

import ec.edu.espe.fromumltocode.model.A;
import ec.edu.espe.fromumltocode.model.B;
import ec.edu.espe.fromumltocode.model.C;
import ec.edu.espe.fromumltocode.model.D;
import ec.edu.espe.fromumltocode.model.E;
import ec.edu.espe.fromumltocode.model.G;
import ec.edu.espe.fromumltocode.model.J;
import ec.edu.espe.fromumltocode.view.ConsoleView;

import java.util.*;

public class MainController {

    private ConsoleView view;

    public MainController(ConsoleView view) {
        this.view = view;
    }

    public void run() {

        A a = new A("A object");
        B b = new B("B object");

        List<E> list1 = Arrays.asList(new E("E1"), new E("E2"));
        List<E> list2 = Arrays.asList(new E("E3"));

        C c = new C("C object", list1);
        D d = new D("D object", list2);

        G g = new G();
        J j = new J();

        A[] arr = {a, b, c, d};

        view.displayMessage("=== OBJECT INFO ===");

        for (A obj : arr) {
            obj.showInfo();
            view.separator();
        }

        b.execute();

        d.getF().showInfo();

        g.useJ(j);

        view.displayMessage("E objects:");
        for (E e : list1) {
            e.showInfo();
        }
    }
}