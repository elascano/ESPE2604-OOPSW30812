package ec.edu.espe.exam2.model;

import java.util.ArrayList;
import java.util.List;

public class B extends A {
    private final List<H> elements;

    public B() {
        super();
        this.elements = new ArrayList<>();
    }

    public void addElement(H element) {
        this.elements.add(element);
    }
    public void display() {
    System.out.println("Clase B [Agregación]: Mostrando elementos agregados.");
    
}
}