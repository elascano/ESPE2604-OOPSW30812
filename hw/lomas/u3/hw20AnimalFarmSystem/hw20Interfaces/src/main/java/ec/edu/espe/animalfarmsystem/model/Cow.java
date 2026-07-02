package ec.edu.espe.animalfarmsystem.model;

import ec.edu.espe.animalfarmsystem.controller.IMeatAnimal;
import java.util.ArrayList;
import java.util.Date;

public class Cow extends FarmAnimal implements IMeatAnimal {

    private float milkDaily;
    private boolean isProducingMilk;
    private SlaughterHouse slaughterHouse;

    public Cow(float milkDaily, boolean isProducingMilk, int id, String breed, Date bornOn, float weight, SlaughterHouse slaughterHouse, Product product, ArrayList<Cut> cut) {
        super(id, breed, bornOn, weight, slaughterHouse, product, cut);
        this.milkDaily = milkDaily;
        this.isProducingMilk = isProducingMilk;
    }

    @Override
    public void feed(Food food) {
        System.out.println("Feeding grass to the cow: " + food);
    }

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> beefCuts = new ArrayList<>();
        return beefCuts;
    }



    public float getMilkDaily() {
        return this.milkDaily;
    }

    public void setMilkDaily(float milkDaily) {
        this.milkDaily = milkDaily;
        if (this.milkDaily <= 0) {
            this.isProducingMilk = false;
        }
    }

    public float getMonthlyMilkProduction() {
        if (!isProducingMilk) {
            return 0.0f;
        }
        return this.milkDaily * 30.0f;
    }

    public void checkProductionStatus(SlaughterHouse place) {
        if (!this.isProducingMilk || this.milkDaily <= 0) {
            sendToSlaughterHouse(place);
            System.out.println("The cow is no longer productive. Dispatched to slaughterhouse.");
        }
    }

    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    @Override
    public SlaughterHouse sendToSlaughterHouse(SlaughterHouse slaughterhouse) {
        this.slaughterHouse = slaughterHouse;
        return null;
    }

}