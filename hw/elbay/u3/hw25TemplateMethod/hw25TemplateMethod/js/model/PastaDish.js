const MealPreparation = require("./MealPreparation");

class PastaDish extends MealPreparation {
    cook() {
        console.log("Boiling pasta and simmering sauce");
    }

    addGarnish() {
        console.log("Adding grated parmesan and basil");
    }
}

module.exports = PastaDish;
