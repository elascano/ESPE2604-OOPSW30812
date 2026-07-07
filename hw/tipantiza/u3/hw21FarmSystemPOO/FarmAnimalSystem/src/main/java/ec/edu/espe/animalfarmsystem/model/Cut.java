
package ec.edu.espe.animalfarmsystem.model;

/**
 *
 * @author Alexander Tipantiza, The Softwariors, @ESPE
 */
public class Cut {
    private int id;
    private String description;
    private String procedure;
    private float weight;

    @Override
    public String toString() {
        return "Cut{" + "id=" + id + ", description=" + description + ", procedure=" + procedure + ", weight=" + weight + '}';
    }
    

    public Cut(int id, String description, String procedure, float weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the procedure
     */
    public String getProcedure() {
        return procedure;
    }

    /**
     * @param procedure the procedure to set
     */
    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }
    
    
}
