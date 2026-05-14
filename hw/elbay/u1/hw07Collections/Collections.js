class Person {
    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    computeAge() {
        let today = new Date();

        let age = today.getFullYear() - this.bornOnDate.getFullYear();

        let monthDifference = today.getMonth() - this.bornOnDate.getMonth();

        if (
            monthDifference < 0 ||
            (monthDifference === 0 &&
                today.getDate() < this.bornOnDate.getDate())
        ) {
            age--;
        }

        return age;
    }

    toString() {
        return `Person{id=${this.id}, fullName='${this.fullName}', bornOnDate=${this.bornOnDate.toDateString()}, alive=${this.alive}}`;
    }
}


let id;
let fullName;
let bornOnDate;
let alive;


// Persona 1
id = 1;
fullName = "Didier Elbay";
bornOnDate = new Date(1970, 11, 17); // Mes empieza en 0
alive = true;

let person = new Person(id, fullName, bornOnDate, alive);

console.log(person.toString());
console.log("Age of person 1 is " + person.computeAge());


// Persona 2
id = 2;
fullName = "Tarjelia Tello";
bornOnDate = new Date(1910, 7, 8);
alive = false;

let person2 = new Person(id, fullName, bornOnDate, alive);

console.log("Age of person 2 is " + person2.computeAge());


// Lista things
let things = [];

things.push(person);
things.push(person2);

console.log("Size of things is " + things.length);


// Lista integers
let integers = [];

integers.push(5);
integers.push(id);

console.log("integers:", integers);


// Lista people
let people = [];

people.push(person);
people.push(person2);

console.log("people:", people);