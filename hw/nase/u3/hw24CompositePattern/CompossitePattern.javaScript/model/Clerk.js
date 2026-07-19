
import { Employee } from './Employee.js';

//Jennyfer Nase

export class Clerk extends Employee {
    constructor(aName = null) {
        super();
        this.title = "Clerk";
        if (aName !== null) {
            this.name = aName;
        }
    }

    stateName() {
        super.stateName();
    }
}