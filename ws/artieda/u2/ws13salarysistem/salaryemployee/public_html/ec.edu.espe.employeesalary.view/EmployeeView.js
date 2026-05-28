/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

class EmployeeView {

    showEmployees(employees) {

        let output = "<h3>Employees</h3>";

        employees.forEach(employee => {

            output +=
                "Name: " + employee.name +
                " | Salary: $" + employee.salary +
                "<br>";
        });

        document.getElementById("output").innerHTML = output;
    }

    showTotalSalary(total) {

        document.getElementById("output").innerHTML +=
            "<h3>Total Salary: $" + total + "</h3>";
    }
}
