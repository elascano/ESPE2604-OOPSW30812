package projectjson;

import java.io.FileWriter;
import java.io.IOException;

public class ProjectJSON {

    public static void main(String[] args) {
        System.out.println("--- CREATING JSON FILE ---");

        // Los datos en formato JSON (Inglés)
        String jsonContent = "[\n" +
            "  { \"id\": 1, \"name\": \"Matthew Smith\", \"birth_date\": \"05/12/2001\", \"GPA\": 3.8 },\n" +
            "  { \"id\": 2, \"name\": \"Emily Johnson\", \"birth_date\": \"08/22/2002\", \"GPA\": 4.0 },\n" +
            "  { \"id\": 3, \"name\": \"Christopher Davis\", \"birth_date\": \"01/30/2000\", \"GPA\": 3.2 },\n" +
            "  { \"id\": 4, \"name\": \"Ashley Taylor\", \"birth_date\": \"11/14/2003\", \"GPA\": 3.9 },\n" +
            "  { \"id\": 5, \"name\": \"Joshua Wilson\", \"birth_date\": \"03/05/2002\", \"GPA\": 3.5 }\n" +
            "]";

        try (FileWriter file = new FileWriter("students.json")) {
            file.write(jsonContent);
            System.out.println(">>> DONE! File 'students.json' created in the project folder.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}