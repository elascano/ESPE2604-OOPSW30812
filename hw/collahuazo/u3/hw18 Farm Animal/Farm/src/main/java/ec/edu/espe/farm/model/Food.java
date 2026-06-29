package ec.edu.espe.farm.model;

/**
 * @author Collahuazo Brandon, CodeBros, @ESPE
 */
public class Food {
  
    private int id;
    private String description;
    private String suitableFor;


    public Food() {
    }

 
    public Food(int id, String description, String suitableFor) {
        this.id = id;
        this.description = description;
        this.suitableFor = suitableFor;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuitableFor() {
        return suitableFor;
    }

    public void setSuitableFor(String suitableFor) {
        this.suitableFor = suitableFor;
    }
}