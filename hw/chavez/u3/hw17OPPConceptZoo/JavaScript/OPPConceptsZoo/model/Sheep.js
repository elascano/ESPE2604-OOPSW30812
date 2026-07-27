import FarmAnimal from "./FarmAnimal.js";

export default class Sheep extends FarmAnimal {

    constructor(id, breed, bornOn, weight) {
        super(id, breed, bornOn, weight);
    }

    shear() {
        return "Wool";
    }

}