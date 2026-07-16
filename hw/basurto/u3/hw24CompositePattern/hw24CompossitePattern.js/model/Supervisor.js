import { Employee } from './Employee.js';

export class Supervisor extends Employee {
    constructor() {
        super();
        this.directReports = [];
    }

    stateName() {
        super.stateName();
        for (const report of this.directReports) {
            report.stateName();
        }
    }

    add(employee) {
        this.directReports.push(employee);
    }
}