
package ec.edu.espe.animalfarmsystem.controller;

import ec.edu.espe.animalfarmsystem.model.Product;

/**
 *
 * @author Christopher Lomas
 */
public interface IProduceAnimal {
    
    public Product produce();
    public void measureQuantity(String unit, float quantity);
    
}
