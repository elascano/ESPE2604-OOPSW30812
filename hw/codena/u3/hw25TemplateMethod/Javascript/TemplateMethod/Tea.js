const CaffeineBeverage = require("./CaffeineBeverage");
const prompt = require("prompt-sync")();

class Tea extends CaffeineBeverage {

    brew() {
        console.log("Steeping the tea");
    }

    addCondiments() {
        console.log("Adding Lemon");
    }

    getUserInput() {
        return prompt("Would you like lemon with your tea (y/n)? ");
    }
}

module.exports = Tea;