/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

class EmployeeModel {

    constructor() {
        this.employees = [];
    }

    saveNames(name1, name2, name3) {

        this.employees = [
            { name: name1, salary: 0 },
            { name: name2, salary: 0 },
            { name: name3, salary: 0 }
        ];
    }

    saveSalaries(salary1, salary2, salary3) {

        this.employees[0].salary = parseFloat(salary1);

        this.employees[1].salary = parseFloat(salary2);

        this.employees[2].salary = parseFloat(salary3);
    }

    calculateTotalSalary() {

        let total = 0;

        this.employees.forEach(employee => {
            total += employee.salary;
        });

        return total;
    }
}
