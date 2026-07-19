const Employee = require('./Employee');

class Clerk extends Employee {
    constructor(aName) {
        super();
        this.title = "Clerk";
        if (aName) {
            this.name = aName;
        }
    }
}
module.exports = Clerk;
