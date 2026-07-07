package ec.edu.espe.animalfarmsystem.controller;

import ec.edu.espe.animalfarmsystem.model.Product;

/**
 *
 * @author Brandon Collahuazo,Polymorphism,ESPE
 */
public interface IProduceAnimal {
    public Product produce(int productId);
    public void measureQuantity(String unit, float quantity);
    

}
