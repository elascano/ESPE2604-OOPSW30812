const Employee = require("./Employee");

class Supervisor extends Employee {

    constructor(name, title) {
        super(name, title);
        this.employees = [];
    }

    add(employee) {
        this.employees.push(employee);
    }

    remove(employee) {
        this.employees = this.employees.filter(e => e !== employee);
    }

    display() {
        console.log(`${this.title}: ${this.name}`);

        this.employees.forEach(employee => employee.display());
    }
}

module.exports = Supervisor;