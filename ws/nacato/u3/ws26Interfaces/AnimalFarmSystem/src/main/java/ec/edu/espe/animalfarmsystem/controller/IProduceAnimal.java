/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.animalfarmsystem.controller;
import ec.edu.espe.animalfarmsystem.model.Product;

/**
 *
 * @author Cristian Palmo,Error 404 @ESPE
 */
public interface IProduceAnimal {
    public Product produce();
    public void measureQuantity(String unit, float quantity);
    
    
}
