
package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Cut;
import ec.edu.espe.oopconceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

/**
 *
 * @author Christopher Lomas, <CodeBros>, ESPE
 */
public interface IMeatAnimal {
    public ArrayList<Cut> cut();
    public void sendToSlaughterHouse(SlaughterHouse slaughterhouse );
    
}
