import FarmAnimal from "./FarmAnimal.js";
import Cut from "./Cut.js";
import SlaughterHouse from "./SlaughterHouse.js";

export default class Cow extends FarmAnimal {

    cut() {
        console.log("Cow has been cut");

        const cuts = [
            new Cut("Brisket"),
            new Cut("Rib"),
            new Cut("Loin"),
            new Cut("Chuck")
        ];

        cuts.forEach(cut => console.log(cut.toString()));
    }

    sendToSlaughterHouse(name) {
        const slaughterHouse = new SlaughterHouse(name);
        slaughterHouse.slaughter(this);
    }
}