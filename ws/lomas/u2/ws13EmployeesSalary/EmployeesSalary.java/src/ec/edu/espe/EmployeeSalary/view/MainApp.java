
package ec.edu.espe.EmployeeSalary.view;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
import ec.edu.espe.EmployeeSalary.model.Employee;
import ec.edu.espe.EmployeeSalary.model.EmployeeModel;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM (JAVA) ===");
        System.out.print("How many employees do you want to register? ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\n--- Registering Employee #" + (i + 1) + " ---");
            System.out.print("Enter Employee ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Employee Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            model.addEmployee(id, name, salary);
        }

 
        System.out.println("\n[INFO]: Saving employee data to JSON file...");
        if (model.saveToFile()) {
            System.out.println("[INFO]: Data saved successfully.");
        }

      
        double totalNeeded = model.calculateTotalSalaries();
        
        System.out.println("\n=================================");
        System.out.println("        EMPLOYEE PAYROLL         ");
        System.out.println("=================================");
        for (Employee emp : model.getEmployees()) {
            System.out.printf("ID: %s | Name: %s | Salary: $%.2f\n", emp.getId(), emp.getName(), emp.getSalary());
        }
        System.out.println("---------------------------------");
        System.out.printf("TOTAL BUDGET REQUIRED: $%.2f\n", totalNeeded);
        System.out.println("=================================\n");
        
        scanner.close();
    }
}