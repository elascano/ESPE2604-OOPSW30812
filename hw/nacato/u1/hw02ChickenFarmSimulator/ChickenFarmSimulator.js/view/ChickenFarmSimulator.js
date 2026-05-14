const Chicken = require('../model/Chicken');

class ChickenFarmSimulator {
    static main() {
        
        let chicken;

        chicken = new Chicken(1, "Lucy", "White and Brown", 1, true);
        console.log("My Chicken is ---->" + chicken.toString());
    }
}
ChickenFarmSimulator.main();