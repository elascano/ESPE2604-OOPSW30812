const Cut = require("./Cut");

class SlaughterHouse {

    constructor(name, location) {
        this.name = name;
        this.location = location;
    }

    processAnimal(animal) {

        const cuts = [];

        cuts.push(new Cut(1, "Rib", 5.0, 8.50));
        cuts.push(new Cut(2, "Loin", 4.0, 10.00));
        cuts.push(new Cut(3, "Shoulder", 6.5, 7.75));

        return cuts;
    }

    getInformation() {
        return {
            name: this.name,
            location: this.location
        };
    }

    toString() {
        return `Slaughter House: ${this.name}
Location: ${this.location}`;
    }

}

module.exports = SlaughterHouse;