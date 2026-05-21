package ec.edu.espe.EmployeeSalary.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    private final String filePath = "employees.json";
    private List<Employee> employees;
    private final Gson gson;

    public EmployeeModel() {
        this.employees = new ArrayList<>();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void addEmployee(String id, String name, String clockIn, String clockOut, String role, double salary) {
        Employee newEmployee = new Employee(id, name, clockIn, clockOut, role, salary);
        this.employees.add(newEmployee);
    }

    public boolean saveToFile() {
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(this.employees, writer);
            return true;
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
            return false;
        }
    }

    public void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            this.employees = new ArrayList<>();
            return;
        }
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<ArrayList<Employee>>() {}.getType();
            List<Employee> loaded = gson.fromJson(reader, listType);
            this.employees = (loaded != null) ? loaded : new ArrayList<>();
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
            this.employees = new ArrayList<>();
        }
    }

    public double calculateTotalSalaries() {
        return this.employees.stream().mapToDouble(Employee::getSalary).sum();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }
}