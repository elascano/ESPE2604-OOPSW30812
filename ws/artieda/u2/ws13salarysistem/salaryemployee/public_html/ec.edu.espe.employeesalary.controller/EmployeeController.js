/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
const model = new EmployeeModel();

const view = new EmployeeView();


// ===== CASE 1 =====
function saveNames() {

    let name1 = prompt("Enter employee 1 name");

    let name2 = prompt("Enter employee 2 name");

    let name3 = prompt("Enter employee 3 name");

    model.saveNames(name1, name2, name3);

    alert("Employee names saved");
}


// ===== CASE 2 =====
function saveSalaries() {

    let salary1 = prompt(
        "Enter salary for " + model.employees[0].name
    );

    let salary2 = prompt(
        "Enter salary for " + model.employees[1].name
    );

    let salary3 = prompt(
        "Enter salary for " + model.employees[2].name
    );

    model.saveSalaries(salary1, salary2, salary3);

    alert("Salaries saved");

    view.showEmployees(model.employees);
}


// ===== CASE 3 =====
function calculateTotalSalary() {

    let total = model.calculateTotalSalary();

    view.showTotalSalary(total);
}
 

