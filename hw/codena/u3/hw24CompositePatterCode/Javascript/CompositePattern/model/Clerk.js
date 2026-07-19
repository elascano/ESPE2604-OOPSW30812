import Employee from "./Employee.js";

export default class Clerk extends Employee {

    constructor(name) {
        super();
        this.title = "Clerk";
        this.name = name;
    }

}