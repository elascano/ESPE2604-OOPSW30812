const Supervisor = require("./Supervisor");

class President extends Supervisor {

    constructor(name) {
        super(name);
    }

    stateName() {
        return `President: ${this.name}`;
    }

}

module.exports = President;