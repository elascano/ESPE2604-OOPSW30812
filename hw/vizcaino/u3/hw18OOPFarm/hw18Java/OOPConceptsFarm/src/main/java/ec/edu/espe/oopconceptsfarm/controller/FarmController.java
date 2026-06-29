/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptsfarm.controller;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import ec.edu.espe.oopconceptsfarm.model.*;
import ec.edu.espe.oopconceptsfarm.utils.MongoConnection;

import java.util.ArrayList;

public class FarmController {

    private Farm farm;
    private MongoConnection connection;

    public FarmController(Farm farm, MongoConnection connection) {

        this.farm = farm;
        this.connection = connection;
    }

    public void addAnimal(FarmAnimal animal) {

        farm.addAnimal(animal);

        connection.saveAnimal(animal);
    }

    public void feedAnimal(int animalId, Food food) {

        for (FarmAnimal animal : farm.getAnimals()) {

            if (animal.getId() == animalId) {

                animal.feed(food);

                connection.saveAnimal(animal);

                break;
            }
        }
    }

    public FarmAnimal findAnimal(int animalId) {

        for (FarmAnimal animal : farm.getAnimals()) {

            if (animal.getId() == animalId) {
                return animal;
            }
        }

        return null;
    }

    public void updateAnimal(FarmAnimal animal) {

        connection.saveAnimal(animal);
    }

    public ArrayList<FarmAnimal> getAnimals() {

        return farm.getAnimals();
    }
    public void deleteAnimal(int id){

    FarmAnimal animal =
            findAnimal(id);

    if(animal != null){

        farm.removeAnimal(id);

        connection.deleteAnimal(
                animal.getClass().getSimpleName(),
                id);
    }
}
}