package ec.edu.espe.oppconcetszoo.controller;

import ec.edu.espe.oppconcetszoo.model.Cut;
import ec.edu.espe.oppconcetszoo.model.SlaughterHouse;
import java.util.ArrayList;

public interface IMeatAnimal {

    ArrayList<Cut> cut();

    void sendToSlaughterHouse(SlaughterHouse slaughterHouse);

}