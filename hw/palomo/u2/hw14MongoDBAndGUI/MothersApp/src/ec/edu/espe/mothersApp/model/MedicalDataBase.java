/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import java.util.ArrayList;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */

public class MedicalDataBase {

    private ArrayList<String> medicalHistory = new ArrayList<>();

    public void saveHistory(String record) {

        medicalHistory.add(record);

        System.out.println("Medical history saved successfully.");
    }

    public void showHistory() {

        System.out.println("\n____  MEDICAL HISTORY ____ ");

        if (medicalHistory.isEmpty()) {

            System.out.println("No medical records found.");
            return;
        }

        for (int i = 0; i < medicalHistory.size(); i++) {

            System.out.println((i + 1) + ". " + medicalHistory.get(i));
        }
    }
}