package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;
//@uthor Christopher Lomas,<CodeBros>,ESPE
public class Pig extends FarmAnimal implements IMeatAnimal {
    private float idealWeight;
    private SlaughterHouse slaughterHouse;

    @Override
    public void feed(Food food) {
        System.out.println("Feedin THE PIG with food --> " + food + "in a bowl and water");
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        return cuts;
    }

    

    public float getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(float idealWeight) {
        this.idealWeight = idealWeight;
    }

    public Pig(float idealWeight, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cut);
        this.idealWeight = idealWeight;
    }

    @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        this.slaughterHouse = slaughterHouse;
        return null;
    }
}
