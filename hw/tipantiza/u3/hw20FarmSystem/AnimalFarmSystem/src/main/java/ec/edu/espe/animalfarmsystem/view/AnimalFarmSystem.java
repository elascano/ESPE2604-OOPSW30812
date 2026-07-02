
package ec.edu.espe.animalfarmsystem.view;

import ec.edu.espe.animalfarmsystem.model.Cow;
import ec.edu.espe.animalfarmsystem.model.Pig;
import ec.edu.espe.animalfarmsystem.model.SlaughterHouse;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, The Softwariors, @ESPE
 */
public class AnimalFarmSystem {

    public static void main(String[] args) {
        System.out.println("ANIMAL FARM SYSTEM\n");
        
        SlaughterHouse slaughterHouse = new SlaughterHouse(1, "ESPE SlaghterHouse", "Sangolqui, Matriz ESPE", "0997515132");
        
        Pig pig = new Pig(120.0f, false, 88.0f, "Duroc", new Date(), 1, slaughterHouse, null, new ArrayList<>());

        Cow cow = new Cow(2, false, "Holstein", new Date(), 450.0f, slaughterHouse, null, new ArrayList<>(), 0f);
        
        System.out.println("Pig created: " + pig.getId() + " - " + pig.getBreed());
        System.out.println("Cow created: " + cow.getId() + " - " + cow.getBreed());
        
        System.out.println("\n---> Sending to SlaughterHouse");
        pig.sendToSlaughterHouse(slaughterHouse);
        cow.sendToSlaughterHouse(slaughterHouse);
        
        System.out.println("\nPROGRAM COMPLETED");
    }
}
