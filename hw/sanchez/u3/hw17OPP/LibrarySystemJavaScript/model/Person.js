class Person {
    constructor(id, name) {
        if (this.constructor === Person) {
            throw new Error("Abstract class.");
        }

        this.id = id;
        this.name = name;
    }
}

module.exports = Person;