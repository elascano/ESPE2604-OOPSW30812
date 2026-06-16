
package ec.edu.espe.speaker.model;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class Speaker {
    private int id;
    private String name;
    private String description; 
    private double power;
    private double impedance;

    // Constructor
    public Speaker(int id, String name, String description, double power, double impedance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.power = power;
        this.impedance = impedance;
    }

    // Getters y Setters (todos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getPower() { return power; }
    public void setPower(double power) { this.power = power; }
    
    public double getImpedance() { return impedance; }
    public void setImpedance(double impedance) { this.impedance = impedance; }
    
    // Lógica de negocio
    public double calculatePerformance() {
        return power / impedance;
    }
}