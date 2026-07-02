/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Product;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */
public interface IProduceAnimal {
    public Product produce();
    public void measureQuantity(String unit, float quantity);
}
