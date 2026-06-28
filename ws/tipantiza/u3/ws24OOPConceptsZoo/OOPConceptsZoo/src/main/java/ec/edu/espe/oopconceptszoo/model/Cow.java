
package ec.edu.espe.oopconceptszoo.model;

import ec.edu.espe.oopconceptszoo.controller.IMeatAnimal;
import java.util.ArrayList;

/**
 *
 * @author Alexander Tipantiza, SoftWarriors, @ESPE
 */
public class Cow extends FarmAnimal implements IMeatAnimal{

    @Override
    public ArrayList<Cut> cut() {
        ArrayList<Cut> cuts;
        cuts = new ArrayList<>();
        System.out.println("cutting to -->" +cuts);
        return cuts;
    }

    @Override
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse) {
        System.out.println("sendint the cow to Slaughter House -->" +slaughterHouse);
    }

    @Override
    public void food(Food food) {
        System.out.println("Feeding a cow with -->" +food);
    }
    
}
