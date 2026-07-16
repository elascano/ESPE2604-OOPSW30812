const Employee = require('./employee');

class Teller extends Employee {
    constructor(name) {
        super();
        this.title = "Teller";
        if (name) {
            this.name = name;
        }
    }

    stateName() {
        super.stateName();
    }
}

module.exports = Teller;