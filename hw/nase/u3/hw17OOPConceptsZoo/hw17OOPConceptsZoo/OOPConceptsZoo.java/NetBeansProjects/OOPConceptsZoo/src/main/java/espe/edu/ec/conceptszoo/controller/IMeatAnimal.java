package espe.edu.ec.conceptszoo.controller;

import espe.edu.ec.conceptszoo.model.Cut;
import espe.edu.ec.conceptszoo.model.SlaughterHouse;
import java.util.ArrayList;

public interface IMeatAnimal {
    ArrayList<Cut> cut();
    void sendToSlaughterHouse(SlaughterHouse slaughterhouse);
}