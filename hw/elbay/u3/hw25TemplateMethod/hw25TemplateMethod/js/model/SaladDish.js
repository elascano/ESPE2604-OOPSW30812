const MealPreparation = require("./MealPreparation");

class SaladDish extends MealPreparation {
    cook() {
        console.log("Chopping vegetables and mixing dressing");
    }

    addGarnish() {
        console.log("Adding croutons and sesame seeds");
    }
}

module.exports = SaladDish;
