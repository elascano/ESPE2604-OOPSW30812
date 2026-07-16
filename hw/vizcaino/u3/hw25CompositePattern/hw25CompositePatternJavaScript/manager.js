const Supervisor = require('./supervisor');

class Manager extends Supervisor {
    constructor(name) {
        super();
        this.title = "Manager";
        if (name) {
            this.name = name;
        }
    }

    stateName() {
        super.stateName();
    }
}

module.exports = Manager;