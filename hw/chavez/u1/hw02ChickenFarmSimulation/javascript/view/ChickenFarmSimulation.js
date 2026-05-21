const { Chicken } = require("../model/Chicken.js");

class ChickenFarmSimulation {
    mostrar() {
        this.chicken = new Chicken(1, "Lucy", "White and brown", 1, true);
        console.log("My Chicken is ---> " + this.chicken.toString());
    }
}

module.exports = { ChickenFarmSimulation };