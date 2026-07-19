const CaffeineBeverage = require("./CaffeineBeverage");
const prompt = require("prompt-sync")();

class Coffee extends CaffeineBeverage {

    brew() {
        console.log("Dripping coffee through filter");
    }

    addCondiments() {
        console.log("Adding sugar and milk");
    }

    getUserInput() {
        return prompt("Would you like milk and sugar with your coffee (y/n)? ");
    }
}

module.exports = Coffee;