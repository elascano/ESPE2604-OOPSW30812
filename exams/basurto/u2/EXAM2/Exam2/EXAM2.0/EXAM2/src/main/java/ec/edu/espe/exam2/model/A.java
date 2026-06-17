package ec.edu.espe.exam2.model;

import java.util.ArrayList;
import java.util.List;

public class A {
    private List<A> subParts;

    public A() {
        this.subParts = new ArrayList<>();
    }

    public void addSubPart(A part) {
        if (this.subParts.size() < 1) {
            this.subParts.add(part);
        }
    }

    public void display() {
    System.out.println("Clase A [Composición]: Mostrando estructura compuesta de A.");
    if (subParts != null) { 
        System.out.println(" -> Contiene subpartes de tipo A.");
    }
    }
}