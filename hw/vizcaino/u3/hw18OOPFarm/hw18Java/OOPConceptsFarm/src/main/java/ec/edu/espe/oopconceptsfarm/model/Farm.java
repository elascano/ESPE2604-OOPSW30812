/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.model;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import java.util.ArrayList;

public class Farm {

    private int id;
    private String name;

    private ArrayList<FarmAnimal> animals;

    public Farm(int id, String name) {

        this.id = id;
        this.name = name;

        animals = new ArrayList<>();
    }

    public void addAnimal(FarmAnimal animal) {
        animals.add(animal);
    }

    public ArrayList<FarmAnimal> getAnimals() {
        return animals;
    }
    public void removeAnimal(int id){

    animals.removeIf(
            animal -> animal.getId() == id);
   }
}
