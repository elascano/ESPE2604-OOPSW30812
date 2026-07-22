import Pig from "../model/Pig.js";
import Cow from "../model/Cow.js";
import Chicken from "../model/Chicken.js";
import Sheep from "../model/Sheep.js";
import Food from "../model/Food.js";

export default class AnimalController {

    static run() {

        const food = new Food("Corn");

        console.log("\n----- PIG -----");
        const pig = new Pig(1, "Yorkshire", "2025-01-15");
        pig.feed(food);
        pig.sendToSlaughterHouse("Juan");
        pig.cut();

        console.log("\n----- COW -----");
        const cow = new Cow(2, "Holstein", "2024-05-20");
        cow.feed(food);
        cow.sendToSlaughterHouse("Mario");
        cow.cut();

        console.log("\n----- CHICKEN -----");
        const chicken = new Chicken(3, "Leghorn", "2025-02-10");
        chicken.feed(food);
        chicken.produce();

        console.log("\n----- SHEEP -----");
        const sheep = new Sheep(4, "Mar", "2024-09-18");
        sheep.feed(food);
        sheep.produce();
    }

}