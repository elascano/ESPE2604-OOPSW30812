import { Employee } from './Employee.js';

//Jennyfer Nase

export class Supervisor extends Employee {
    constructor() {
        super();
        if (this.constructor === Supervisor) {
            throw new Error("Abstract class 'Supervisor' cannot be instantiated directly.");
        }
        this.directReports = []; 
    }

    stateName() {
        super.stateName(); 
        if (this.directReports.length > 0) {
            for (const emp of this.directReports) {
                emp.stateName();
            }
        }
    }

    add(anEmployee) {
        this.directReports.push(anEmployee);
    }
}