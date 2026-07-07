package ec.edu.espe.animalfarrmsystem.controller;

import ec.edu.espe.animalfarrmsystem.model.Product;

public interface IProduceAnimal {

    public Product produce();

    public void measureQuantity(String unit, float quantity);

}