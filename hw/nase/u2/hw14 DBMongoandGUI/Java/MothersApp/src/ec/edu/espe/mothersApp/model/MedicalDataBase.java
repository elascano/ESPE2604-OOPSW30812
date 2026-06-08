package ec.edu.espe.mothersApp.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.mothersApp.model.Mother; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MedicalDataBase {

    private ArrayList<Mother> medicalHistory = new ArrayList<>();
    
    private static final String FILE_PATH = "mothers_database.json";

    public MedicalDataBase() {
        loadHistoryFromJson();
    }

    public void saveHistory(Mother motherRecord) {
        medicalHistory.add(motherRecord);

        saveHistoryToJson();

        System.out.println("Medical history saved successfully in JSON.");
    }

    public void showHistory() {
        System.out.println("\n____  MEDICAL HISTORY ____ ");

        if (medicalHistory.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }

        for (int i = 0; i < medicalHistory.size(); i++) {
            Mother m = medicalHistory.get(i);
            System.out.println((i + 1) + ". " + m.firstName + " " + m.lastName + " (ID: " + m.id + ")");
        }
    }

    private void saveHistoryToJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(medicalHistory, writer); 
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + e.getMessage());
        }
    }

    private void loadHistoryFromJson() {
        Gson gson = new Gson();
        
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type type = new TypeToken<ArrayList<Mother>>(){}.getType();
            ArrayList<Mother> loadedList = gson.fromJson(reader, type);
            
            if (loadedList != null) {
                this.medicalHistory = loadedList;
            }
        } catch (IOException e) {
            this.medicalHistory = new ArrayList<>();
        }
    }
}