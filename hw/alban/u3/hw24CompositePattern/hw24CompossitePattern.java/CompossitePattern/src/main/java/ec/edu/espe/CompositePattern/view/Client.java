package ec.edu.espe.CompositePattern.view;

import ec.edu.espe.CompositePattern.model.Employee;

public class Client {
    public static Employee employee;

    public static void doClientTasks() {
        if (employee != null) {
            employee.stateName();
        }
    }
}