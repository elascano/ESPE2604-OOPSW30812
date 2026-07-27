export default class FarmAnimal {

    constructor(id, breed, bornOn, weight) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
    }

    feed(food) {
        console.log(
            `${this.breed} is eating ${food.description}`
        );
    }

}