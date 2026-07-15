const Employee = require('./employee');

class Supervisor extends Employee {
    constructor() {
        super();
        if (this.constructor === Supervisor) {
            throw new Error("Cannot instantiate abstract class Supervisor");
        }
        this.directReports = [];
    }

    stateName() {
        super.stateName();
        if (this.directReports.length > 0) {
            for (let i = 0; i < this.directReports.length; i++) {
                this.directReports[i].stateName();
            }
        }
    }

    add(employee) {
        this.directReports.push(employee);
    }
}

module.exports = Supervisor;