import { Supervisor } from './Supervisor.js';

//Jennyfer Nase

export class President extends Supervisor {
    static #instance = null; 

    constructor(aName = null) {
        if (President.#instance) {
            if (aName !== null) {
                President.#instance.name = aName;
            }
            return President.#instance;
        }

        super();
        this.title = "President";
        this.name = aName !== null ? aName : "not assigned yet";
        President.#instance = this;
    }

    stateName() {
        super.stateName();
    }

    static getPresident(aName) {
        return new President(aName);
    }
}