class Employee {

    constructor(name) {
        this.name = name;
    }

    stateName() {
        throw new Error("Method stateName() must be implemented");
    }

}

module.exports = Employee;