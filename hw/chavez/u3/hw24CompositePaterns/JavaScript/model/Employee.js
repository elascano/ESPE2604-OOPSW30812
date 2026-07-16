export default class Employee {

    constructor(name, title) {
        this.name = name;
        this.title = title;
    }

    stateName() {
        console.log(`${this.title} ${this.name}`);
    }
}