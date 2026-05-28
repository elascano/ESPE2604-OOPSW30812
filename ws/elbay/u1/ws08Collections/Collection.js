/**
 *
 * @author Didier Elbay <Code_Bros , @ESPE>
 */

class Person {
    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    computeAge() {
        let currentDate = new Date();
        let age = currentDate.getFullYear() - this.bornOnDate.getFullYear();

        let monthDifference = currentDate.getMonth() - this.bornOnDate.getMonth();

        if (
            monthDifference < 0 ||
            (monthDifference === 0 &&
                currentDate.getDate() < this.bornOnDate.getDate())
        ) {
            age--;
        }

        return age;
    }

    toString() {
        let isAlive = this.alive ? "YES" : "NO";

        return `Person{id=${this.id}, fullName=${this.fullName}, bornOnDate=${this.bornOnDate.toDateString()}, alive=${isAlive}}`;
    }
}

let id;
let fullName;
let bornOnDate;
let alive;

// Person 1
id = 1;
fullName = "Didier Elbay";
bornOnDate = new Date(1970, 11, 17);
alive = true;

let person = new Person(id, fullName, bornOnDate, alive);

console.log(person.toString());
console.log("Age of person 1 is " + person.computeAge());

// Person 2
id = 2;
fullName = "Tarjelia Tello";
bornOnDate = new Date(1910, 7, 8);
alive = false;

let person2 = new Person(id, fullName, bornOnDate, alive);

console.log(person2.toString());
console.log("Age of person 2 is " + person2.computeAge());

let things = [];
things.push(person);
things.push(person2);

console.log("Size of things is " + things.length);

let integers = [];
integers.push(5);
integers.push(id);

console.log("integers: ", integers);

let people = [];
people.push(person);
people.push(person2);

console.log("people: ", people);