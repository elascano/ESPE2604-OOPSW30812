
package ec.edu.espe.animalfarmsystem.controller;

import ec.edu.espe.animalfarmsystem.model.Cut;
import ec.edu.espe.animalfarmsystem.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Alexander Tipantiza, The Softwariors, @ESPE
 */
public interface IMeatAnimal {
    
    public ArrayList<Cut> cut();
    
    public void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
    
}
