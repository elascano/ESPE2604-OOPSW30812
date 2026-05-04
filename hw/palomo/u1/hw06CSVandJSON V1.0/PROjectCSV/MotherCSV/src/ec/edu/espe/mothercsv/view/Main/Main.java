/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothercsv.view;

import ec.edu.espe.mothercsv.model.Mother;
import ec.edu.espe.mothercsv.utils.MotherCSV;
import java.util.List;
/**
 *
 * @author Cristian
 */

public class Main {
    public static void main(String[] args) {
        
        Mother mother1 = new Mother(1, "Ana Perez", 30, "ana.perez@email.com");
        MotherCSV.saveMother(mother1);

        Mother mother2 = new Mother(2, "Maria Lopez", 28, "maria.lopez@email.com");
        MotherCSV.saveMother(mother2);

        List<Mother> mothers = MotherCSV.readMothers();
        System.out.println("Lista de madres registradas:");
        for (Mother m : mothers) {
            System.out.println(m.getId() + " - " + m.getName() + " - " + m.getAge() + " edad - " + m.getEmail());
        }
    }
}

