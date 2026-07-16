class Employee {
    constructor() {
        if (this.constructor === Employee) {
            throw new Error("Cannot instantiate abstract class Employee");
        }
        this.name = "not assigned yet";
        this.title = "not assigned yet";
    }

    stateName() {
        console.log(`${this.title} ${this.name}`);
    }
}

module.exports = Employee;