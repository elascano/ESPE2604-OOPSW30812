/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.ede.espe.Exam.view;

import ec.ede.espe.Exam.model.B;
import ec.ede.espe.Exam.model.C;
import ec.ede.espe.Exam.model.D;
import ec.ede.espe.Exam.model.E;
import ec.ede.espe.Exam.model.G;
import ec.ede.espe.Exam.model.J;

/**
 *
 * @author Joel Sanchez <The_Softwarriors at ESPE>
 */
public class Main {

    public static void main(String[] args) {

        J j = new J();
        G g = new G(j);

        B b = new B(g);

        E e1 = new E("E1");
        E e2 = new E("E2");

        C c = new C();
        c.addE(e1);

        D d = new D();
        d.addE(e1);
        d.addE(e2);
        d.addF("F1");
        d.addF("F2");

        System.out.println("===== UML TEST =====");

        System.out.println(g);
        g.execute();

        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
