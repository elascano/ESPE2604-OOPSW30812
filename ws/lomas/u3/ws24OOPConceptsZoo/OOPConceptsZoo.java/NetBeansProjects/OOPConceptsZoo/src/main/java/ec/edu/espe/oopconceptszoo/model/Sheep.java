package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

public class Sheep extends FarmAnimal {
    Date lastSheering;

    public Sheep(int id, String breed, Date bornOn, float weight, Date lastSheering) {
        super(id, breed, bornOn, weight);
        this.lastSheering = lastSheering;
    }

    public Date getLastSheering() { return lastSheering; }
}