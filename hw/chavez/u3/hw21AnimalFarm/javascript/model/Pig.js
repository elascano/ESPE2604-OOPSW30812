import FarmAnimal from "./FarmAnimal.js";
import Cut from "./Cut.js";
import SlaughterHouse from "./SlaughterHouse.js";

export default class Pig extends FarmAnimal {

    cut() {
        console.log("Pig has been cut");

        const cuts = [
            new Cut("Loin"),
            new Cut("Belly"),
            new Cut("Feet")
        ];

        cuts.forEach(cut => console.log(cut.toString()));
    }

    sendToSlaughterHouse(name) {
        const slaughterHouse = new SlaughterHouse(name);
        slaughterHouse.slaughter(this);
    }
}