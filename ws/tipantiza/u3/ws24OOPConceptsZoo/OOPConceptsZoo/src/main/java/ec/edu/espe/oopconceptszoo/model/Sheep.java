
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, SoftWarriors, @ESPE
 */
public class Sheep extends FarmAnimal{
    Date lastSheering;
    @Override
    public void food(Food food) {
        System.out.println("feddomt a sjeep with" +food);
    }
    
}
