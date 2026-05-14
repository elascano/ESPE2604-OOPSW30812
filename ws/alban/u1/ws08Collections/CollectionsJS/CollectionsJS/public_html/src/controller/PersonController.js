import { Person } from '../model/Person.js';

export class PersonController {
    constructor() {
        this.people = [];
    }

    addPerson(person) {
        this.people.push(person);
    }

    getPeople() {
        return this.people;
    }
}


