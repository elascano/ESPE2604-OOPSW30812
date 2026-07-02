/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.controller;

import ec.espe.edu.farmanimalsystem.model.Product;

/**
 *
 * @author Cristian
 */
public interface IProduceAnimal {
    public Product produce();
    public void measureQuality(String unit, float quantity);
}
