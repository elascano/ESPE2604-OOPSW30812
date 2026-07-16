import { Employee } from './Employee.js';

//Jennyfer Nase

export class Teller extends Employee {
    constructor(aName = null) {
        super();
        this.title = "Teller";
        if (aName !== null) {
            this.name = aName;
        }
    }

    stateName() {
        super.stateName();
    }
}