package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Cut;
import ec.edu.espe.oopconceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

/**
 * Contract for animals that can be processed for meat.
 *
 * @author Didier Elbay
 */
public interface IMeatAnimal {

    /**
     * Returns the list of meat cuts produced from this animal.
     */
    ArrayList<Cut> cut();

    /**
     * Sends this animal to the specified slaughterhouse.
     */
    void sendToSlaughterHouse(SlaughterHouse slaughterhouse);
}
