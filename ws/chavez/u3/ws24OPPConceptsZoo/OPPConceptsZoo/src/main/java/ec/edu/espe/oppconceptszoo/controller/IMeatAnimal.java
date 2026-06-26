/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.controller;

import ec.edu.espe.oppconceptszoo.model.Cut;
import ec.edu.espe.oppconceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public void sendToSlaugnterHouse(SlaughterHouse slaugthterHouse);
}
