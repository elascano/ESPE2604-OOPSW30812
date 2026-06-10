
package ec.edu.espe.safestore.model;

/**
 *
 * @author Alexander Tipantiza, The Softwarriors, @ESPE
 */
import java.util.ArrayList;
import java.util.List;

public class Supplier {
    private int id;
    private String name;
    private String contactPerson;
    private String phone;
    private String email;
    private String address;
    private double creditTerm;
    private double currentDebt;
    private double creditLimit;
    private List<Integer> invoiceIds;
    private boolean isActive;
    
    public Supplier() {
        this.invoiceIds = new ArrayList<>();
        this.isActive = true;
    }
    
    public Supplier(int id, String name, String contactPerson, String phone, String email, String address, double creditTerm, double creditLimit) {
        this.id = id;
        this.name = name;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.creditTerm = creditTerm;
        this.creditLimit = creditLimit;
        this.currentDebt = 0;
        this.invoiceIds = new ArrayList<>();
        this.isActive = true;
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public double getCreditTerm() { return creditTerm; }
    public void setCreditTerm(double creditTerm) { this.creditTerm = creditTerm; }
    public double getCurrentDebt() { return currentDebt; }
    public void setCurrentDebt(double currentDebt) { this.currentDebt = currentDebt; }
    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
    public List<Integer> getInvoiceIds() { return invoiceIds; }
    public void setInvoiceIds(List<Integer> invoiceIds) { this.invoiceIds = invoiceIds; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    
    public void addInvoiceId(int invoiceId) {
        invoiceIds.add(invoiceId);
    }
    
    @Override
    public String toString() {
        return "Supplier{id=" + id + ", name=" + name + ", contactPerson=" + contactPerson + "}";
    }
}
