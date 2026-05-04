package projectcsv;

import java.io.PrintWriter;

public class ProjectCSV {

    public static void main(String[] args) {
        System.out.println("Generating CSV file with English headers and data...");

        try {
            // Creamos el archivo
            PrintWriter writer = new PrintWriter("students.csv");

            // Encabezados en INGLÉS (ID, Name, Birth Date, GPA)
            // Usamos ; para que Excel cree las celdas separadas
            writer.println("id;name;birth date;GPA");

            // Datos con nombres y formatos en INGLÉS
            writer.println("1;Matthew Smith;05/12/2001;3.8");
            writer.println("2;Emily Johnson;08/22/2002;4.0");
            writer.println("3;Christopher Davis;01/30/2000;3.2");
            writer.println("4;Ashley Taylor;11/14/2003;3.9");
            writer.println("5;Joshua Wilson;03/05/2002;3.5");

            writer.close(); // Guardar cambios

            System.out.println("SUCCESS! The file 'students.csv' has been created with English content.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}