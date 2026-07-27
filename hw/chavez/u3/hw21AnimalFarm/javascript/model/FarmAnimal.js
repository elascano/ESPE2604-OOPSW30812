export default class FarmAnimal {
    constructor(id, breed, bornOn) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
    }

    feed(food) {
        console.log(`Feeding the ${this.constructor.name.toUpperCase()} with food -> ${food.name} in a bowl and water`);
    }
}