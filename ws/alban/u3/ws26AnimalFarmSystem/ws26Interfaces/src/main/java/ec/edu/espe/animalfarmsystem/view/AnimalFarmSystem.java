package ec.edu.espe.animalfarmsystem.view;

import ec.edu.espe.animalfarmsystem.model.Pig;
import ec.edu.espe.animalfarmsystem.model.Cow;
import java.util.Date;
//@uthor Christopher Lomas,<CodeBros>,ESPE
public class AnimalFarmSystem {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Pig pig = new Pig(0, 0, "Duroc", new Date(), 0, slaughterHouseObj, productObj, cutsListObj);
        
        Cow cow = new Cow(0, true, 0, "HolsteinChris", new Date(), 0, slaughterHouseObj, productObj, cutsListObj);
    }
}