/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.motherjson.view;

import ec.edu.espe.motherjson.model.Mother;
import ec.edu.espe.motherjson.utils.MotherJSON;
import java.util.*;

/**
 *
 * @author Cristian
 */
public class Main {
    public static void main(String[] args) {
        // Crear lista de madres
        List<Mother> mothers = new ArrayList<>();
        mothers.add(new Mother(1, "Ana Perez", 30, "ana.perez@email.com"));
        mothers.add(new Mother(2, "Maria Lopez", 28, "maria.lopez@email.com"));

        // Guardar en JSON
        MotherJSON.saveMothers(mothers);

        // Leer desde JSON
        List<Mother> loadedMothers = MotherJSON.readMothers();
        System.out.println("Madres registradas en JSON:");
        for (Mother m : loadedMothers) {
            System.out.println(m.getId() + " - " + m.getName() + " - " + m.getAge() + " edad - " + m.getEmail());
        }
    }
}

