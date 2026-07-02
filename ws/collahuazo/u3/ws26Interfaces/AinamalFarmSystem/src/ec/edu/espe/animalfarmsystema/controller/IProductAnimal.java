/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.animalfarmsystema.controller;

import ec.edu.espe.animalfarmsystema.model.Product;

/**
 *
 * @author Collahuazo Brandon,CodeBros,@ESPE
 */
public interface IProductAnimal {
    public Product produce();
    public void measureQuantity(String unit, float quantity);
}
