import { Employee } from './Employee.js';

export class Teller extends Employee {
    constructor(name) {
        super();
        this.title = "Teller";
        if (name) {
            this.name = name;
        }
    }
}