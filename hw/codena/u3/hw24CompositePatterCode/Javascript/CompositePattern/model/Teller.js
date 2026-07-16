import Employee from "./Employee.js";

export default class Teller extends Employee {

    constructor(name) {
        super();
        this.title = "Teller";
        this.name = name;
    }

}