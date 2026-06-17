package ec.edu.espe.exam2.model;

import java.util.ArrayList;
import java.util.List;

public class C extends A {
    private final List<E> aggregationElements;

    public C() {
        super();
        this.aggregationElements = new ArrayList<>();
    }

    public void addElement(E element) {
        if (this.aggregationElements.size() < 3) {
            this.aggregationElements.add(element);
        }
    }
    
public void display() {
    System.out.println("Clase C [Agregación]: Mostrando elementos agregados.");
    
    
    if (this.aggregationElements != null && !this.aggregationElements.isEmpty()) { 
        System.out.println(" -> Contiene un elemento agregado de tipo E.");
    } else {
        System.out.println(" -> Sin elementos de tipo E asignados.");
    }
}
}