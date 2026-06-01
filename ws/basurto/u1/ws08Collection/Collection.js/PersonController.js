// Jennyfer Nase
import { Person } from './Person.js';

export class PersonController {
    static getExtendedPeople(p1, p2) {
        const peopleList = [p1, p2];

        for (let i = 3; i <= 7; i++) {
            peopleList.push(new Person(i, "Jennyfer", "2026-05-09", true));
        }
        return peopleList;
    }
}