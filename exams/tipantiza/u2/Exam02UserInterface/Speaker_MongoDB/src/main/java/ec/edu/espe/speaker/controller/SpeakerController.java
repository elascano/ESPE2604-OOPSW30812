
package ec.edu.espe.speaker.controller;
import ec.edu.espe.speaker.model.Speaker;
import ec.edu.espe.speaker.database.DataBaseConnection; 
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
public class SpeakerController {
    private List<Speaker> speakers;
    private DataBaseConnection dbConnection;

    public SpeakerController() {
        speakers = new ArrayList<>();
        dbConnection = new DataBaseConnection();
    }

    // CREATE
    public void createSpeaker(int id, String name, String description, double power, double impedance) {
        Speaker speaker = new Speaker(id, name, description, power, impedance);
        speakers.add(speaker);
         System.out.println("Speaker created: " + name);
         dbConnection.saveSpeaker(speaker);
        
        System.out.println("✓ Speaker created: " + name);
        System.out.println("  Total speakers in memory: " + speakers.size());
    }

    // READ ALL
    public List<Speaker> getAllSpeakers() {
        return speakers;
    }

    // READ BY ID
    public Speaker findById(int id) {
        for (Speaker s : speakers) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // UPDATE
    public boolean updateSpeaker(int id, String name, String description, double power, double impedance) {
        Speaker s = findById(id);
        if (s != null) {
            s.setName(name);
            s.setDescription(description);
            s.setPower(power);
            s.setImpedance(impedance);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean deleteSpeaker(int id) {
        Speaker s = findById(id);
        return speakers.remove(s);
    }

    // Obtener performance
    public double getPerformanceById(int id) {
        Speaker s = findById(id);
        if (s != null) {
            return s.calculatePerformance();
        }
        return -1;
    }
     public int getTotalCount() {
        return speakers.size();  
    }
     // SHOW ALL IN CONSOLE (for debugging)
    public void showAllSpeakers() {
        System.out.println("\n=== SPEAKERS IN MEMORY ===");
        if (speakers.isEmpty()) {
            System.out.println("No speakers saved yet");
        } else {
            for (Speaker s : speakers) {
                System.out.println("ID: " + s.getId() + 
                                 " | Name: " + s.getName() +
                                 " | Description: " + s.getDescription() +
                                 " | Power: " + s.getPower() + "W" +
                                 " | Impedance: " + s.getImpedance() + "Ω" +
                                 " | Performance: " + String.format("%.2f", s.calculatePerformance()));
            }
        }
        System.out.println("Total: " + speakers.size() + " speakers\n");
    }
}