package ec.edu.espe.OOPQuiz.model;

import java.util.ArrayList;
import java.util.List;

public class D extends A {
    private List<E> boundedElements;
    private F compositionPart;

    public D() {
        super();
        this.boundedElements = new ArrayList<>();
        this.compositionPart = new F();
    }

    public void addBoundedElement(E element) {
        if (this.boundedElements.size() < 5) {
            this.boundedElements.add(element);
        }
    }
    
    public void display() {
        System.out.println("Clase D [Asociación Acotada y Composición]: Mostrando estructura.");
        
        
        if (this.boundedElements != null && !this.boundedElements.isEmpty()) {
            System.out.println(" -> Posee " + this.boundedElements.size() + " elemento(s) acotado(s) de tipo E.");
        } else {
            System.out.println(" -> Sin elementos acotados de tipo E asignados.");
        }
        
        
        if (this.compositionPart != null) {
            System.out.println(" -> Contiene una parte compuesta fija de tipo F.");
        }
    }
}