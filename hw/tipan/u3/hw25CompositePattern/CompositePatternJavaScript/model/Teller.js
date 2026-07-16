const Employee = require("./Employee");

class Teller extends Employee {

    constructor(name) {
        super(name);
    }

    stateName() {
        return `Teller: ${this.name}`;
    }

}

module.exports = Teller;