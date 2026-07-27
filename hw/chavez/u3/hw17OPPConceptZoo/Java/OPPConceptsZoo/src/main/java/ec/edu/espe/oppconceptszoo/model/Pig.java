/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.oppconceptszoo.model;

import ec.edu.espe.oppconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Odalys Chavez , CodeBreakers, @ESPE
 */
public class Pig extends FarmAnimal implements IMeatAnimal {

    public Pig(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }
    public boolean canBeSlaughtered() {
        return getWeight() >= 90;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();

        cuts.add(new Cut(1, "Ham"));
        cuts.add(new Cut(2, "Bacon"));
        cuts.add(new Cut(3, "Pork loin"));

        return cuts;
    }

    @Override
    public void sendToSlaugnterHouse(SlaughterHouse slaugthterHouse) {
        System.out.println("Pig sent to slaughterhouse");
    }
    
}
