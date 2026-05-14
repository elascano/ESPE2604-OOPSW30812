import { Person } from '../model/Person.js';
import { PersonController } from '../controller/PersonController.js';

export class CollectionsApp {
    static run() {
        console.log("--- ESPE Collections App (JS) ---");
        const controller = new PersonController();

        const p1 = new Person(1, "Christopher", 20);
        const p2 = new Person(2, "Wendy", 21);

        controller.addPerson(p1);
        controller.addPerson(p2);

        console.log("Stored Data:");
        controller.getPeople().forEach(p => console.log(p.toString()));
    }
}

