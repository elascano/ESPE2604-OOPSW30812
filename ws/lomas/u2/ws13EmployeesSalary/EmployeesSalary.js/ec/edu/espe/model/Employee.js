class Employee {
    constructor(id, name, salary) {
        this.id = id;
        this.name = name;
        this.salary = parseFloat(salary);
    }
}

module.exports = Employee;
