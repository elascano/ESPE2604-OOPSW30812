class Employee {
    constructor(id, name, clockIn, clockOut, role, salary) {
        this.id = id;
        this.name = name;
        this.clockIn = clockIn;   
        this.clockOut = clockOut; 
        this.role = role;
        this.salary = parseFloat(salary);
    }
}

module.exports = Employee;
