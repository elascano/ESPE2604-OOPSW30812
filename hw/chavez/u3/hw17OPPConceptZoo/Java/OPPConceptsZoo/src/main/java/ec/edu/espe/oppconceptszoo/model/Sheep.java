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
public class Sheep extends FarmAnimal implements IMeatAnimal{
    private Date lastSheering;

    public Sheep(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }

    public boolean canShear() {
        return true;
    }

    @Override
    public ArrayList<Cut> cut() {

        ArrayList<Cut> cuts = new ArrayList<>();

        cuts.add(new Cut(1, "Leg"));
        cuts.add(new Cut(2, "Shoulder"));

        return cuts;
    }

    @Override
    public void sendToSlaugnterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("Sheep sent to slaughterhouse");
    }
    
    
}
