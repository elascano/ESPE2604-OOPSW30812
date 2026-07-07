package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Chicken;
import ec.edu.espe.oopconceptszoo.model.Cow;
import ec.edu.espe.oopconceptszoo.model.Cut;
import java.util.ArrayList;

public class FarmBusinessLogic {

    public static float calculateExpectedMeatYield(IMeatAnimal animal) {
        float totalWeight = 0;
        ArrayList<Cut> cuts = animal.cut();
        for (Cut cut : cuts) {
            totalWeight += cut.getWeight();
        }
        return totalWeight;
    }

    public static boolean isEligibleForEggProduction(Chicken chicken) {
        if (!chicken.isMolting() && chicken.getNumberOfEggsPerWeek() > 2) {
            return true;
        }
        return false;
    }

    public static float calculateMilkEfficiency(Cow cow) {
        if (cow.getWeight() <= 0) {
            return 0;
        }
        return (cow.milk() / cow.getWeight()) * 100;
    }
}