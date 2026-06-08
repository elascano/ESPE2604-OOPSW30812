
package ec.edu.espe.EmployeeSalary.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */

public class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
}
    
