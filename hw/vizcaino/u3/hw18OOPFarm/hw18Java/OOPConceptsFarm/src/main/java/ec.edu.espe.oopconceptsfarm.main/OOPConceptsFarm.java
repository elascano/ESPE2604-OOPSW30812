package ec.edu.espe.oopconceptsfarm;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */

import ec.edu.espe.oopconceptsfarm.controller.FarmController;
import ec.edu.espe.oopconceptsfarm.model.Farm;
import ec.edu.espe.oopconceptsfarm.utils.MongoConnection;
import ec.edu.espe.oopconceptsfarm.view.FarmView;

public class OOPConceptsFarm {

    public static void main(String[] args) {

        Farm farm =
                new Farm(1, "ESPE Farm");

        MongoConnection connection =
                new MongoConnection();

        FarmController controller =
                new FarmController(
                        farm,
                        connection);

        FarmView view =
                new FarmView(controller);

        view.setVisible(true);
    }
}