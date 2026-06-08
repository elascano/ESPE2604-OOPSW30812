

const EmployeeModel = require('../model/EmployeeModel');
const EmployeeView = require('./EmployeeView');
const readline = require('readline/promises'); // Módulo nativo para leer teclado
const { stdin: input, stdout: output } = require('process');


const model = new EmployeeModel();
const employeeView = new EmployeeView();

async function runApplication() {
   
    const rl = readline.createInterface({ input, output });
    
    employeeView.displayMessage("=== EMPLOYEE MANAGEMENT SYSTEM ===");
    employeeView.displayMessage("The order to register the employees is this");
    employeeView.displayMessage("Enter the number of employees you wish to register, then enter the details in the following order: ID, Name and Salary  ");
    
    
    
    const numEmployeesInput = await rl.question("How many employees do you want to register? ");
    const numEmployees = parseInt(numEmployeesInput);

    if (isNaN(numEmployees) || numEmployees <= 0) {
        employeeView.displayMessage("Invalid number. Exiting program.");
        rl.close();
        return;
    }

   
    for (let i = 0; i < numEmployees; i++) {
        console.log(`\n--- Registering Employee #${i + 1} ---`);
        
        const id = await rl.question("Enter Employee ID: ");
        const name = await rl.question("Enter Employee Name: ");
        const salaryInput = await rl.question("Enter Employee Salary: ");
        const salary = parseFloat(salaryInput);

               if (isNaN(salary) || salary < 0) {
            console.log("[ERROR]: Invalid salary. Please register this employee again.");
            i--; // Repetir este turno del ciclo
            continue;
        }

       
        model.addEmployee(id, name, salary);
    }

    
    rl.close();

    
    console.log("");
    employeeView.displayMessage("Saving employee data to JSON file...");
    if (model.saveToFile()) {
        employeeView.displayMessage("Data saved successfully.");
    }

   
    employeeView.displayMessage("Clearing local memory and reloading data from JSON file...");
    model.loadFromFile();

   
    const totalNeeded = model.calculateTotalSalaries();
    const employeeList = model.getEmployees();

    
    employeeView.displaySalaryReport(employeeList, totalNeeded);
}

// Arrancamos la función asíncrona
runApplication();


