const Supervisor = require('./supervisor');

class President extends Supervisor {
    static _instance = null;

    constructor(name) {
        super();
        this.title = "President";
        if (name) {
            this.name = name;
        }
    }

    stateName() {
        super.stateName();
    }

    static getPresident(name) {
        if (!President._instance) {
            President._instance = new President();
        }
        President._instance.name = name;
        return President._instance;
    }
}

module.exports = President;