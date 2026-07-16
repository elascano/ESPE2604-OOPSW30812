const Supervisor = require("./Supervisor");

class Manager extends Supervisor {

    constructor(name) {
        super(name);
    }

    stateName() {
        return `Manager: ${this.name}`;
    }

}

module.exports = Manager;