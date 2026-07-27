/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.hw18farm.controller;

import ec.edu.espe.hw18farm.model.Cut;
import ec.edu.espe.hw18farm.model.SlaughterHouse;
import java.util.ArrayList;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
public class IMeatAnimal {
    
    public ArrayList<Cut> cut();
    public abstract void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
    
}   
