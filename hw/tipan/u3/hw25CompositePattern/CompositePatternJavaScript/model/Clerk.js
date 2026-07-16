const Employee = require("./Employee");

class Clerk extends Employee {

    constructor(name) {
        super(name);
    }

    stateName() {
        return `Clerk: ${this.name}`;
    }

}

module.exports = Clerk;