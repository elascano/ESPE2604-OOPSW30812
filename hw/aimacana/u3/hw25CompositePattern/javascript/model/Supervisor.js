const Employee = require('./Employee');

class Supervisor extends Employee {
    constructor() {
        super();
        this.directReports = [];
    }
    
    stateName() {
        let result = super.stateName();
        if (this.directReports.length > 0) {
            for (let i = 0; i < this.directReports.length; ++i) {
                result += this.directReports[i].stateName();
            }
        }
        return result;
    }
    
    add(anEmployee) {
        this.directReports.push(anEmployee);
    }
}
module.exports = Supervisor;
