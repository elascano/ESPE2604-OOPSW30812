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
public class Cow extends FarmAnimal implements IMeatAnimal{

    public Cow(int id, String breed, Date bornOn, float weight) {
        super(id, breed, bornOn, weight);
    }
    public float milk() {
        return getWeight() * 0.08f;
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts = new ArrayList<>();
        cuts.add(new Cut(1, "Rib"));
        cuts.add(new Cut(2, "Steak"));
        cuts.add(new Cut(3, "Loin"));

        return cuts;
    }

    @Override
    public void sendToSlaugnterHouse(SlaughterHouse slaugthterHouse) {
        System.out.println("Cow sent to slaughterhouse: "+ slaughterHouse.getName());

    }

    private static class slaughterHouse {

        private static String getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public slaughterHouse() {
        }
    }
}