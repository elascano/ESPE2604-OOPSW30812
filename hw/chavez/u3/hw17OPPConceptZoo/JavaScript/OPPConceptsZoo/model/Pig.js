import FarmAnimal from "./FarmAnimal.js";

export default class Pig extends FarmAnimal {

    constructor(id, breed, bornOn, weight) {
        super(id, breed, bornOn, weight);
    }

    cut() {
        return ["Ham", "Bacon", "Loin"];
    }

}