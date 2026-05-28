// Jennyfer Nase
import { Person } from './Person.js';
import { PersonController } from './PersonController.js';

function main() {
    const p1 = new Person(1, "Jennyfer Nase", "2006-08-10", true);
    const p2 = new Person(2, "Tarjelia Tello", "1910-08-08", false);

    const things = [8000, 3.5, "Quito", true, p1, p2, 4078.76, "a"];
    console.log(`size of things --> ${things.length}`);
    console.log("These are my things -->");
   
    console.log(`[${things.map(t => t.toString()).join(', ')}]`);

    const people = [p1, p2];
    console.log(`\npeople --> [${people.map(p => p.toString()).join(', ')}]`);
    
    console.log("");
    people.forEach(p => {
        console.log(`Person -->${p.toString()}`);
    });

    console.log("");
    const fullList = PersonController.getExtendedPeople(p1, p2);
    
    fullList.forEach(p => {
        console.log(`Person -->${p.toString()}`);
    });
}

main();