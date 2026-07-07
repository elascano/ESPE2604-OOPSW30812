
package ec.edu.espe.animalfarmsystem.controller;

import ec.edu.espe.animalfarmsystem.model.Product;

/**
 *
 * @author Alexander Tipantiza, The Softwariors, @ESPE
 */
public interface IProduceAnimal {
    
    public Product produce();
    public void measureQuantity(String unit, float quantity);
    
    
}
