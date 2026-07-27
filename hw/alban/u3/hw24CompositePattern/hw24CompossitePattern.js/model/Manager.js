import { Supervisor } from './Supervisor.js';

export class Manager extends Supervisor {
    constructor(name) {
        super();
        this.title = "Manager";
        if (name) {
            this.name = name;
        }
    }
}