const Employee = require("./Employee");

class Teller extends Employee {

    constructor(name) {
        super(name, "Teller");
    }

    display() {
        console.log(`${this.title}: ${this.name}`);
    }
}

module.exports = Teller;