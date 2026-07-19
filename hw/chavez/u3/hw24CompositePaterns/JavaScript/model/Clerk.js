import Employee from "./Employee.js";

export default class Clerk extends Employee {

    constructor(name) {
        super(name, "Clerk: ");
    }
}