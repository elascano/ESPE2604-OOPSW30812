/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.classdiagram.controller;

import ec.edu.espe.classdiagram.model.*;
import ec.edu.espe.classdiagram.view.VistaConsola;
/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */

public class Controlador {

    private VistaConsola vista;

    public Controlador() {
        vista = new VistaConsola();
    }

    public void iniciar() {

        vista.mostrarMensaje("===== DIAGRAMA UML =====");

        A padre = new A();
        padre.agregarHijo(new A());
        padre.agregarHijo(new A());

        vista.mostrarMensaje(padre.toString());

        J j = new J();
        G g = new G(j);

        g.ejecutar();

        B b = new B();
        b.agregarH(g);

        vista.mostrarMensaje(b.toString());

        C c = new C();

        c.agregarE(new E("E1"));
        c.agregarE(new E("E2"));

        vista.mostrarMensaje(c.toString());

        D d = new D();

        d.agregarE(new E("E3"));
        d.agregarE(new E("E4"));

        d.agregarF(new F("F1"));
        d.agregarF(new F("F2"));

        vista.mostrarMensaje(d.toString());

        vista.mostrarMensaje("===== FIN =====");
    }
}
