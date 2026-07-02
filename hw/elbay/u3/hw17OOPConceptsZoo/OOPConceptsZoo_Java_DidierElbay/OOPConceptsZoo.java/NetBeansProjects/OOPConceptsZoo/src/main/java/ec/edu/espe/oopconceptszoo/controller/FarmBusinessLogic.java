package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Chicken;
import ec.edu.espe.oopconceptszoo.model.Cow;
import ec.edu.espe.oopconceptszoo.model.Cut;
import java.util.ArrayList;

/**
 * Business logic for farm operations.
 *
 * @author Didier Elbay
 */
public class FarmBusinessLogic {

    /**
     * Calculates the total expected meat yield (kg) from an animal's cuts.
     */
    public static float calculateExpectedMeatYield(IMeatAnimal animal) {
        float totalWeight = 0f;
        for (Cut cut : animal.cut()) {
            totalWeight += cut.getWeight();
        }
        return totalWeight;
    }

    /**
     * Returns true if a chicken qualifies for egg production
     * (not molting and producing more than 2 eggs per week).
     */
    public static boolean isEligibleForEggProduction(Chicken chicken) {
        return !chicken.isMolting() && chicken.getNumberOfEggsPerWeek() > 2;
    }

    /**
     * Calculates milk efficiency as a percentage of body weight.
     */
    public static float calculateMilkEfficiency(Cow cow) {
        if (cow.getWeight() <= 0) return 0f;
        return (cow.getMilkAmount() / cow.getWeight()) * 100f;
    }
}
