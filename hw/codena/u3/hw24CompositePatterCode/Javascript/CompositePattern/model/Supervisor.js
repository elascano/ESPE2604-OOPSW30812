import Employee from "./Employee.js";

export default class Supervisor extends Employee {

    constructor() {
        super();
        this.directReports = [];
    }

    stateName() {

        super.stateName();

        for (const employee of this.directReports) {
            employee.stateName();
        }

    }

    add(employee) {
        this.directReports.push(employee);
    }

    remove(employee) {
        this.directReports =
            this.directReports.filter(e => e !== employee);
    }

    getChild(index) {
        return this.directReports[index];
    }

}