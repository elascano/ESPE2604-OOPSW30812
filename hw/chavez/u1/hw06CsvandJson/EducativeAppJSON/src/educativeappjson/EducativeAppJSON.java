/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package educativeappjson;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class EducativeAppJSON {

    
    public static void main(String[] args) {
       
        System.out.println("--- CREATING JSON FILE ---");

        String jsonContent = "[\n" + 
            "  { \"id\": 10, \"name\": \"Carlos Ruiz\", \"birth_date\": \"15/03/2005\", \"grade_avg\": 3.9 },\n" +
            "  { \"id\": 11, \"name\": \"Ana Gomez\", \"birth_date\": \"22/07/2004\", \"grade_avg\": 4.0 },\n" +
            "  { \"id\": 12, \"name\": \"Luis Fernandez\", \"birth_date\": \"10/11/2005\", \"grade_avg\": 3.6 },\n" +
            "  { \"id\": 13, \"name\": \"Marta Diaz\", \"birth_date\": \"03/09/2004\", \"grade_avg\": 3.8 },\n" +
            "  { \"id\": 14, \"name\": \"Pedro Castro\", \"birth_date\": \"28/12/2005\", \"grade_avg\": 3.7 }\n" +
            "]";

        try (FileWriter file = new FileWriter("students.json")) {
            file.write(jsonContent);
            System.out.println(">>> DONE! File 'students.json' created with completely new data.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}