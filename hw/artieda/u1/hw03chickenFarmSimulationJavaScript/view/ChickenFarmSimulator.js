import { Chicken } from "../model/Chicken.js";

export class ChickenFarmSimulator {
    mostrar() {
        this.chicken = new Chicken(1, "Lucy", "White and brown", 1, true);
        console.log("my chicken is -->" + this.chicken.toString());
    }
}