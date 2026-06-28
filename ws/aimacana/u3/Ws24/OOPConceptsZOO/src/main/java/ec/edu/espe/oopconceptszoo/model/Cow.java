/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;

/**
 *
 * @author Ronald Tipan <The_Softwarrios at ESPE>
 */
public class Cow extends FarmAnimal implements IMeatAnimal {

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
    public void sendToSlughterHouse(SlughterHouse slughterHouse) {
        System.out.println("Seeding cow");
    }
    
    
}
