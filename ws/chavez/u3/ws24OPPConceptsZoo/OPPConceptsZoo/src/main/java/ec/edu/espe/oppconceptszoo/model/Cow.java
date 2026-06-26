/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

import ec.edu.espe.oppconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;

/**
 *
 * @author Esteban Basurto , CodeBreakers, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal{

    @Override
    public void feed(Food food) {
         System.out.println("Feeding a cow with -->" + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        System.out.println("Cutting to -->" + cuts);
        return cuts;
    }

    @Override
    public void sendToSlaugnterHouse(SlaughterHouse slaugthterHouse) {
       System.out.println("Seeding cow");}


}
