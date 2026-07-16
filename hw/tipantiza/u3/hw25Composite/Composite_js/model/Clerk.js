const Employee = require("./Employee");

class Clerk extends Employee {

    constructor(name) {
        super(name, "Clerk");
    }

    display() {
        console.log(`${this.title}: ${this.name}`);
    }
}

module.exports = Clerk;