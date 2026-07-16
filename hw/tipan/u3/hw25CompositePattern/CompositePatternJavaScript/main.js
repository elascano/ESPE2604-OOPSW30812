const EmployeeController = require("./controller/EmployeeController");
const Supervisor = require("./model/Supervisor");

function printOrganization(employee, level = 0) {

    console.log("   ".repeat(level) + employee.stateName());

    if (employee instanceof Supervisor) {

        employee.getDirectReports().forEach(emp => {
            printOrganization(emp, level + 1);
        });

    }

}

const controller = new EmployeeController();

const president = controller.buildOrganization();

console.log("\n===== Composite Pattern =====\n");

printOrganization(president);