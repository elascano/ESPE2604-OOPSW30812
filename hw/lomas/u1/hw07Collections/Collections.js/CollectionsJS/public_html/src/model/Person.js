export class Person {
    constructor(id, name, age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    toString() {
        return `Person [ID=${this.id}, Name=${this.name}, Age=${this.age}]`;
    }
}


