const Employee = require('./Employee');

class Teller extends Employee {
    constructor(aName) {
        super();
        this.title = "Teller";
        if (aName) {
            this.name = aName;
        }
    }
}
module.exports = Teller;
