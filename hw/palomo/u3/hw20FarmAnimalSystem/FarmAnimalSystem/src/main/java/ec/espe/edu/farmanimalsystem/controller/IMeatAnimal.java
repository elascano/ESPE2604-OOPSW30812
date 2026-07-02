/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.farmanimalsystem.controller;

import java.util.ArrayList;
import ec.espe.edu.farmanimalsystem.model.SlaughterHouse;
import ec.espe.edu.farmanimalsystem.model.Cut;


/**
 *
 * @author Cristian
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public SlaughterHouse sendToSlaughterHouse (SlaughterHouse slaughterhouse);
}
    