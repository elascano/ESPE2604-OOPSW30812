const { Person } = require("../model/Person.js");

function printTheCollection(things) {
    console.log(`\nsize of things --> ${things.length}`);
    console.log("These are my things --> \n", things);
}
function main() {
    let id = 1;
    let fullName = "Brandon Collahuazo";
    let bornOnDate = new Date(1999, 2, 4); 
    let alive = true;
    let person = new Person(id, fullName, bornOnDate, alive);

    console.log(person.toString());
    console.log("Age of person 1 is " + person.computeAgeInYears());

    id = 2;
    fullName = "Elizabeth Cumbajin";
    bornOnDate = new Date(1962, 3, 23); 
    alive = true;
    let person2 = new Person(id, fullName, bornOnDate, alive);

    let things = [];
    things.push(8000);
    things.push(3.5);
    things.push("Quito");
    things.push(true);

    printTheCollection(things);

    things.push(4078.76);
    things.push("a");

    printTheCollection(things);

    let people = [];
    people.push(person);
    people.push(person2);

    console.log("");

    people.forEach(function(p) {
        console.log("Person --> " + p.toString());
    });
    
    console.log("");

    for (let i = 2; i < 7; i++) {
        people.push(new Person(i + 1, "pepito", new Date(), true));
    }

    people.forEach(function(p) {
        console.log("Person --> " + p.toString());
    });
}

main();