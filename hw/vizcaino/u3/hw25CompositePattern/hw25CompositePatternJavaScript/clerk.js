const Employee = require('./employee');

class Clerk extends Employee {
    constructor(name) {
        super();
        this.title = "Clerk";
        if (name) {
            this.name = name;
        }
    }

    stateName() {
        super.stateName();
    }
}

module.exports = Clerk;