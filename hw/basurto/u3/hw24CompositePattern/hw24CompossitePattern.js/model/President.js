import { Supervisor } from './Supervisor.js';

export class President extends Supervisor {
    static #instance = null;

    constructor(name) {
        if (President.#instance) {
            if (name) {
                President.#instance.name = name;
            }
            return President.#instance;
        }
        super();
        this.title = "President";
        if (name) {
            this.name = name;
        }
        President.#instance = this;
    }

    static getPresident(name) {
        return new President(name);
    }
}