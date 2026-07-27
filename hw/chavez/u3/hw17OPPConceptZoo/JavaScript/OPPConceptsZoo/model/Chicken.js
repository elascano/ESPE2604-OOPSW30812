import FarmAnimal from "./FarmAnimal.js";

export default class Chicken extends FarmAnimal {

    constructor(id, breed, bornOn, weight) {
        super(id, breed, bornOn, weight);
    }

    layEggs() {
        return 7;
    }

}