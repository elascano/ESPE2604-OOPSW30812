import { Supervisor } from './Supervisor.js';

//Jennyfer Nase

export class Manager extends Supervisor {
    constructor(aName = null) {
        super();
        this.title = "Manager";
        if (aName !== null) {
            this.name = aName;
        }
    }

    stateName() {
        super.stateName();
    }
}