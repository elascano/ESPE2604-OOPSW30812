/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package educationappcsv;

import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class EducationAppCSV {

    public static void main(String[] args) {
     
        System.out.println("Generating CSV file with English headers and data...");

        try {
           
            PrintWriter writer = new PrintWriter("students.csv");

            
            writer.println("id;name;birth date;grade_avg");

            
            writer.println("10;Carlos Ruiz;15/03/2005;3.9");
            writer.println("11;Ana Gomez;22/07/2004;4.0");
            writer.println("12;Luis Fernandez;10/11/2005;3.6");
            writer.println("13;Marta Diaz;03/09/2004;3.8");
            writer.println("14;Pedro Castro;28/12/2005;3.7");

            writer.close(); // Guardar cambios

            System.out.println("SUCCESS! The file 'students.csv' has been created with completely new data.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}