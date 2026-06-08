package ec.edu.espe.mothersapp.model;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class Baby {
    private String name;
    private String idCard; 
    private double weight; 
    private double height; 

    public Baby() {}

    public Baby(String name, String idCard, double weight, double height) {
        this.name = name;
        this.idCard = idCard;
        this.weight = weight;
        this.height = height;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    @Override
    public String toString() {
        return "Baby: " + name + " | ID: " + idCard + " | Weight: " + weight + "g | Height: " + height + "cm";
    }
}