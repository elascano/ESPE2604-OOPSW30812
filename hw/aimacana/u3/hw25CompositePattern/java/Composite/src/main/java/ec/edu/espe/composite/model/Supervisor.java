package ec.edu.espe.composite.model;
import java.util.Vector;

public abstract class Supervisor extends Employee {
    protected Vector<Employee> directReports = new Vector<>();
    
    @Override
    public String stateName() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.stateName()); 
        if (directReports.size() > 0) { 
            for (int i = 0; i < directReports.size(); ++i) {
                sb.append(((Employee)directReports.elementAt(i)).stateName());
            }
        }
        return sb.toString();
    }
    
    public void add(Employee anEmployee) {
        this.directReports.addElement(anEmployee);
    }
}
