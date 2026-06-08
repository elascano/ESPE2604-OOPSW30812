class Person {

    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    toString() {
        return `${this.id} - ${this.fullName} - ${this.bornOnDate} - ${this.alive}`;
    }
}

const person1 = new Person(
    1,
    "Ronald",
    "2005-05-10",
    true
);

const person2 = new Person(
    2,
    "Valeria",
    "2006-08-15",
    true
);

const people = [];

people.push(person1);
people.push(person2);

people.forEach((p) => {
    console.log(p.toString());
});