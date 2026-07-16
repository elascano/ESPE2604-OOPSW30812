const Supervisor = require("./Supervisor");

class President extends Supervisor {

    constructor(name) {
        super(name, "President");
    }
}

module.exports = President;