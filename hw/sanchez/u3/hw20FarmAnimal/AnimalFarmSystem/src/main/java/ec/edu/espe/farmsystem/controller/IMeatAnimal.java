/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.farmsystem.controller;

import ec.edu.espe.farmsystem.model.Cut;
import ec.edu.espe.farmsystem.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Joel Sanchez, The_Softwarriors ,@ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public void sendToSlaughterHouse(SlaughterHouse slaugtherHouse);
}
