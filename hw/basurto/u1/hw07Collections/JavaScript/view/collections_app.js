const Person = require('../model/person');

function printTheCollection(things) {

    console.log(
        "\nsize of things --> " +
        things.length
    );

    console.log(
        "These are my things -->"
    );

    things.forEach(item => {

        if (item instanceof Person) {
            console.log(item.toString());
        } else {
            console.log(item);
        }

    });
}

function main() {

    let id;
    let fullName;
    let bornOnDate;
    let alive;

    id = 1;
    fullName = "Daniel Codena";
    bornOnDate = new Date(2006, 4, 15);
    alive = true;

    const person =
        new Person(
            id,
            fullName,
            bornOnDate,
            alive
        );

    console.log(person.toString());

    console.log(
        "Age of person 1 is",
        person.computeAgeInYears()
    );

    id = 2;
    fullName =
        "Eustaquio Perez de la Fuente Pereira";

    bornOnDate = new Date(1990, 11, 11);

    alive = false;

    const person2 =
        new Person(
            id,
            fullName,
            bornOnDate,
            alive
        );

    console.log(
        "Age of person 2 is",
        person2.computeAgeInYears()
    );

    let things = [];

    console.log(
        "size of things -->",
        things
    );

    things.push(8000);
    things.push(3.5);
    things.push("Quito");
    things.push(true);

    printTheCollection(things);

    things.push(person);
    things.push(person2);

    printTheCollection(things);

    things.push(4078.76);
    things.push("a");

    printTheCollection(things);

    let people = [];

    people.push(person);
    people.push(person2);

    console.log("\npeople -->", people);

    people.forEach((p) => {
        console.log("Person -->",
            p.toString());
    });
}

main();