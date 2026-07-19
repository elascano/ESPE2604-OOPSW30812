export default class Employee {

    constructor() {
        this.name = "Not assigned yet";
        this.title = "Not assigned yet";
    }

    stateName() {
        console.log(`${this.title} ${this.name}`);
    }

    add(employee) {
        throw new Error("Leaf objects cannot add employees.");
    }

    remove(employee) {
        throw new Error("Leaf objects cannot remove employees.");
    }

    getChild(index) {
        throw new Error("Leaf objects do not have children.");
    }

}