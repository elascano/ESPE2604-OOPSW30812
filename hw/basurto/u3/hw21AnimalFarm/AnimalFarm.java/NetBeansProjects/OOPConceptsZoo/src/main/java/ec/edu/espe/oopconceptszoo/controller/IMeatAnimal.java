package ec.edu.espe.oopconceptszoo.controller;

import ec.edu.espe.oopconceptszoo.model.Cut;
import ec.edu.espe.oopconceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

public interface IMeatAnimal {
    ArrayList<Cut> cut();
    void sendToSlaughterHouse(SlaughterHouse slaughterhouse);
}