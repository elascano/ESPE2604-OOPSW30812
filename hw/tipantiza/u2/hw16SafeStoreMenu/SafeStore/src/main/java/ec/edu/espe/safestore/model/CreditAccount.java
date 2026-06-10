
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import java.util.ArrayList;
import java.util.List;

public class CreditAccount {
    private int customerId;
    private String customerName;
    private double creditLimit;
    private double currentDebt;
    private List<Transaction> transactions;
    private boolean isBlocked;
    
    public CreditAccount() {
        this.transactions = new ArrayList<>();
        this.isBlocked = false;
    }
    
    public CreditAccount(int customerId, String customerName, double creditLimit) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.currentDebt = 0;
        this.transactions = new ArrayList<>();
        this.isBlocked = false;
    }
    
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
    public double getCurrentDebt() { return currentDebt; }
    public void setCurrentDebt(double currentDebt) { this.currentDebt = currentDebt; }
    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }
    public boolean isBlocked() { return isBlocked; }
    public void setBlocked(boolean blocked) { isBlocked = blocked; }
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType().equals("DEBT")) {
            currentDebt += transaction.getAmount();
        } else if (transaction.getType().equals("PAYMENT")) {
            currentDebt -= transaction.getAmount();
        }
    }
    
    @Override
    public String toString() {
        return "CreditAccount{customerId=" + customerId + ", customerName=" + customerName + ", currentDebt=" + currentDebt + "}";
    }
}
