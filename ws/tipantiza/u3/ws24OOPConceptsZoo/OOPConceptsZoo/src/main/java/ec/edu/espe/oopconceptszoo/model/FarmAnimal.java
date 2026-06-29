
package ec.edu.espe.oopconceptszoo.model;

import java.util.Date;

/**
 *
 * @author Alexander Tipantiza, SoftWarriors, @ESPE
 */
public abstract class FarmAnimal {
    int id;
    String breed;
    Date bornOn;
    float weight;
    
    public int getAgeInMonths(){
      //algotithm to compute the months based on the bornon Date
      return 1;
    }
    public abstract void food (Food food);
}
