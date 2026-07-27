export default class SlaughterHouse {
    constructor(name) {
        this.name = name;
    }

    slaughter(animal) {
        console.log(`The ${animal.constructor.name.toLowerCase()} has been sent to slaughter house ${this.name}`);
    }
}