import { Employee } from './Employee.js';

export class Clerk extends Employee {
    constructor(name) {
        super();
        this.title = "Clerk";
        if (name) {
            this.name = name;
        }
    }
}