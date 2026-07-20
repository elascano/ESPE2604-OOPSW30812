import FarmAnimal from "./FarmAnimal.js";

export default class Cow extends FarmAnimal {

    constructor(id, breed, bornOn, weight) {
        super(id, breed, bornOn, weight);
    }

    produceMilk() {
        return 20;
    }

}