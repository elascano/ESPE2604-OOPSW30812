
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import java.util.ArrayList;
import java.util.List;

public class Combo {
    private int id;
    private String name;
    private String description;
    private List<ComboItem> items;
    private double comboPrice;
    private boolean isActive;
    
    public Combo() {
        this.items = new ArrayList<>();
        this.isActive = true;
    }
    
    public Combo(int id, String name, String description, double comboPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.comboPrice = comboPrice;
        this.items = new ArrayList<>();
        this.isActive = true;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<ComboItem> getItems() { return items; }
    public void setItems(List<ComboItem> items) { this.items = items; }
    public double getComboPrice() { return comboPrice; }
    public void setComboPrice(double comboPrice) { this.comboPrice = comboPrice; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public void addItem(ComboItem item) {
        items.add(item);
    }
    
    public double calculateIndividualPrice() {
        return items.stream().mapToDouble(i -> i.getProductPrice() * i.getQuantity()).sum();
    }
    
    public double getSavings() {
        return calculateIndividualPrice() - comboPrice;
    }
    
    @Override
    public String toString() {
        return "Combo{id=" + id + ", name=" + name + ", comboPrice=" + comboPrice + "}";
    }
}

