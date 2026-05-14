const Person = require('../model/Person');

function printTheCollection(things) {
    console.log("size of things -->" + things.length);
    console.log("These are my Things -->" + things.length);
}

function main() {
    let id = 1;
    let name = "Adrian Vizcaino";
    let bornOnDate = new Date(2006, 4, 17); // ojo: mes empieza en 0
    let alive = true;

    const person = new Person(id, name, bornOnDate, alive);

    console.log(person.toString());
    console.log("age of person 1 is " + person.computeAgeInYears());

    id = 2;
    name = "Cecilia Torres";
    bornOnDate = new Date(1940, 4, 17);
    alive = true;

    const person2 = new Person(id, name, bornOnDate, alive);

    console.log("age of person 2 is " + person2.computeAgeInYears());

    let things = [];
    console.log("size of things -->" + things.length);

    things.push(8000);
    things.push(3.5);
    things.push("Quito");
    things.push(true);

    printTheCollection(things);

    things.push(person);
    things.push(person2);

    printTheCollection(things);

    things.push(4078.76);
    things.push('a');

    printTheCollection(things);

    let integers = [];
    integers.push(5);
    integers.push(id);

    let people = [];
    people.push(person);
    people.push(person2);

    console.log("");
    console.log("people -->" + JSON.stringify(people.map(p => p.toString())));
    console.log("");

    people.forEach(p => {
        console.log("Person --> " + p.toString());
    });

    console.log("");

    for (let i = 2; i < 7; i++) {
        people.push(new Person(i + 1, "Adrian", new Date(), true));
    }

    people.forEach(p => {
        console.log("Person ->>" + p.toString());
    });
}

main();