class EmployeeView {
    displaySalaryReport(employees, totalSalary) {
        console.log("\n=================================");
        console.log("        EMPLOYEE PAYROLL         ");
        console.log("=================================");
        
        if (employees.length === 0) {
            console.log("No employee records found.");
        } else {
            employees.forEach(emp => {
                console.log(`ID: ${emp.id} | Name: ${emp.name} | Salary: $${emp.salary.toFixed(2)}`);
            });
        }
        
        console.log("---------------------------------");
        console.log(`TOTAL BUDGET REQUIRED: $${totalSalary.toFixed(2)}`);
        console.log("=================================\n");
    }

    displayMessage(message) {
        console.log(`[INFO]: ${message}`);
    }
}

module.exports = EmployeeView;

