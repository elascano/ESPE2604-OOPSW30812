//Jennyfer Nase

export class Employee {
    constructor() {
        if (this.constructor === Employee) {
            throw new Error("Abstract class 'Employee' cannot be instantiated directly.");
        }
        this.name = "not assigned yet";
        this.title = "not assigned yet";
    }

    stateName() {
        console.log(`${this.title} ${this.name}`);
    }
}