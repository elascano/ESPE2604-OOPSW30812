package ec.edu.espe.farm.contracts;

import ec.edu.espe.farm.model.Cut;
import ec.edu.espe.farm.model.SlaughterHouse;
import java.util.ArrayList;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public interface IMeatAnimal {
 
    public ArrayList<Cut> cut();
    public boolean sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}