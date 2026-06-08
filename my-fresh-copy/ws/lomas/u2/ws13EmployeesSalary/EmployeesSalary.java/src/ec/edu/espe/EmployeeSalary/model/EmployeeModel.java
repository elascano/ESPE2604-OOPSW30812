
package ec.edu.espe.EmployeeSalary.model;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeModel {
    
    private ArrayList<Employee> employees;
   
    private final String filePath = "src/ec/edu/espe/EmployeeSalary/model/employees.json";

    public EmployeeModel() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String id, String name, double salary) {
        Employee emp = new Employee(id, name, salary);
        this.employees.add(emp);
    }

    
    public boolean saveToFile() {
        try (FileWriter writer = new FileWriter(filePath)) {
            StringBuilder json = new StringBuilder("[\n");
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = employees.get(i);
                json.append("    {\n")
                    .append("        \"id\": \"").append(emp.getId()).append("\",\n")
                    .append("        \"name\": \"").append(emp.getName()).append("\",\n")
                    .append("        \"salary\": ").append(emp.getSalary()).append("\n")
                    .append("    }");
                if (i < employees.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
            json.append("]");
            
            writer.write(json.toString());
            return true;
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not save file: " + e.getMessage());
            return false;
        }
    }

    public double calculateTotalSalaries() {
        double sum = 0;
        for (Employee emp : employees) {
            sum += emp.getSalary();
        }
        return sum;
    }

    public ArrayList<Employee> getEmployees() {
        return this.employees;
    }
}