/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.animalfarm.controller;

import ec.edu.espe.animalfarm.model.Chicken;
import ec.edu.espe.animalfarm.model.Cow;
import ec.edu.espe.animalfarm.model.Cut;
import java.util.ArrayList;
/**
 *
 * @author Cristian Palomo, Error 404, @ESPE
 */
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
