const fs = require('fs');
const Employee = require('./Employee');


class EmployeeModel {
    constructor() {
        
        this.filePath = './ec/edu/espe/model/employees.json';
        this.employees = [];
    }

    addEmployee(id, name, clockIn, clockOut, role, salary) {
        const newEmployee = new Employee(id, name, clockIn, clockOut, role, salary);
        this.employees.push(newEmployee);
    }

    saveToFile() {
        try {
            const jsonData = JSON.stringify(this.employees, null, 4);
            fs.writeFileSync(this.filePath, jsonData, 'utf8');
            return true;
        } catch (error) {
            console.error("Error saving data:", error.message);
            return false;
        }
    }

    loadFromFile() {
        try {
            if (!fs.existsSync(this.filePath)) {
                this.employees = [];
                return;
            }
            const fileData = fs.readFileSync(this.filePath, 'utf8');
            const parsedData = JSON.parse(fileData);
            this.employees = parsedData.map(emp => 
                new Employee(emp.id, emp.name, emp.clockIn, emp.clockOut, emp.role, emp.salary)
            );
        } catch (error) {
            console.error("Error reading data:", error.message);
            this.employees = [];
        }
    }

    calculateTotalSalaries() {
        return this.employees.reduce((sum, employee) => sum + employee.salary, 0);
    }

    getEmployees() {
        return this.employees;
    }
}

module.exports = EmployeeModel;
