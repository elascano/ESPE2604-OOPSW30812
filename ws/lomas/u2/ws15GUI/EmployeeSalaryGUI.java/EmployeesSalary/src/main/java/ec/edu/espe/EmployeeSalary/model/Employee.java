package ec.edu.espe.EmployeeSalary.model;

public class Employee {
    private String id;
    private String name;
    private String clockIn;
    private String clockOut;
    private String role;
    private double salary;

    // Constructor que necesita el EmployeeModel para crear los objetos
    public Employee(String id, String name, String clockIn, String clockOut, String role, double salary) {
        this.id = id;
        this.name = name;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
        this.role = role;
        this.salary = salary;
    }

    // Métodos Getters obligatorios para la lectura de datos
    public String getId() { return id; }
    public String getName() { return name; }
    public String getClockIn() { return clockIn; }
    public String getClockOut() { return clockOut; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
}
