const Supervisor = require("./Supervisor");

class Manager extends Supervisor {

    constructor(name) {
        super(name, "Manager");
    }
}

module.exports = Manager;