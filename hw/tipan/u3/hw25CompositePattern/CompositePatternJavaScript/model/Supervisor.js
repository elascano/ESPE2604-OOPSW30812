const Employee = require("./Employee");

class Supervisor extends Employee {

    constructor(name) {
        super(name);
        this.directReports = [];
    }

    add(employee) {
        this.directReports.push(employee);
    }

    remove(employee) {
        this.directReports =
            this.directReports.filter(e => e !== employee);
    }

    getDirectReports() {
        return this.directReports;
    }

    stateName() {
        return `${this.constructor.name}: ${this.name}`;
    }

}

module.exports = Supervisor;