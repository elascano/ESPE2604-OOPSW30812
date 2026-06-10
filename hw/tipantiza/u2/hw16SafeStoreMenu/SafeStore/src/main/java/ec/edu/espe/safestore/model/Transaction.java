
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import java.util.Date;

public class Transaction {
    private double amount;
    private String description;
    private String type;
    private Date date;
    
    public Transaction() {}
    
    public Transaction(double amount, String description, String type, Date date) {
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = date;
    }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    @Override
    public String toString() {
        return "Transaction{amount=" + amount + ", type=" + type + ", date=" + date + "}";
    }
}
