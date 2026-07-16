class Employee {
    constructor() {
        this.name = "not assigned yet";
        this.title = "not assigned yet";
    }
    
    stateName() {
        return `${this.title} ${this.name}\n`;
    }
}
module.exports = Employee;
