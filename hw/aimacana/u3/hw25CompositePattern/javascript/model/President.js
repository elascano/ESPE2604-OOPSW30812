const Supervisor = require('./Supervisor');

class President extends Supervisor {
    static #instance = new President();
    
    constructor() {
        super();
        this.title = "President";
    }
    
    static getPresident(aName) {
        President.#instance.name = aName;
        return President.#instance;
    }
}
module.exports = President;
