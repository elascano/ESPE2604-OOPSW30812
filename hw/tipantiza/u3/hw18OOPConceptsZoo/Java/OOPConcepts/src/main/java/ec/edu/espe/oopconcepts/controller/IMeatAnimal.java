package ec.edu.espe.oopconcepts.controller;

import ec.edu.espe.oopconcepts.model.Cut;
import ec.edu.espe.oopconcepts.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    
    public abstract void sendToSlaughterHouse(SlaughterHouse slaughterHouse);
}
