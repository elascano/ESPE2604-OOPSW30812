/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import ec.edu.espe.animalfarmsystem.controller.IProduceAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Cow extends FarmAnimal implements IMeatAnimal, IProduceAnimal {
    private boolean producingMilk;
    private float carcassYield;

    public Cow(boolean producingMilk, float carcassYield, int id, String breed, Date bornOn, float Weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cuts) {
        super(id, breed, bornOn, Weight, slaughterHouse, product, cuts);
        this.producingMilk = producingMilk;
        this.carcassYield = carcassYield;
    }

    public float milk() {
        // TODO: Implementar lógica de negocio
        return 0.0f;
    }

    public boolean isProducingMilk() {
        return this.producingMilk;
    }

    public float calculateMeatYield() {
        // TODO: Implementar lógica de negocio
        return 0.0f;
    }

    // Métodos de IMeatAnimal
    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cutsList = new ArrayList<>();
        return cutsList;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    // Métodos de IProduceAnimal
    @Override
    public Product produce() {
        // TODO: Implementar retorno del producto (ej. Leche)
        return null;
    }

    @Override
    public void measureQuantity(String unit, float quantity) {
        // TODO: Implementar lógica de medición
    }

    // Método abstracto heredado de FarmAnimal
    @Override
    public void feed(Food food) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @param producingMilk the producingMilk to set
     */
    public void setProducingMilk(boolean producingMilk) {
        this.producingMilk = producingMilk;
    }

    /**
     * @return the carcassYield
     */
    public float getCarcassYield() {
        return carcassYield;
    }

    /**
     * @param carcassYield the carcassYield to set
     */
    public void setCarcassYield(float carcassYield) {
        this.carcassYield = carcassYield;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + ", producingMilk=" + producingMilk + ", carcassYield=" + carcassYield + '}';
    }
}