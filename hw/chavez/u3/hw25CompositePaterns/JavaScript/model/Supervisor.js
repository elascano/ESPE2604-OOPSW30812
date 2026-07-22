import Employee from "./Employee.js";

export default class Supervisor extends Employee {

    constructor(name, title) {
        super(name, title);
        this.directReports = [];
    }

    add(employee) {
        this.directReports.push(employee);
    }

    stateName() {
        super.stateName();

        this.directReports.forEach(employee => {
            employee.stateName();
        });
    }
}