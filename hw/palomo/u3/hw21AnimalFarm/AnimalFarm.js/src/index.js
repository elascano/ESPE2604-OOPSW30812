import { Cow, Pig, Sheep, Chicken } from "./models.js";
import { FarmBusinessLogic } from "./controller.js";

const cow = new Cow(1, "Holstein", new Date(2022, 4, 1), 650.0, true, 25.0);
const pig = new Pig(2, "Yorkshire", new Date(2023, 1, 15), 110.0, 120.0);
const sheep = new Sheep(3, "Merino", new Date(2021, 8, 10), 70.0, new Date(2024, 2, 1));
const chicken = new Chicken(4, "Leghorn", new Date(2023, 10, 20), 2.5, false, 5);

console.log(FarmBusinessLogic.calculateExpectedMeatYield(cow));
console.log(FarmBusinessLogic.calculateExpectedMeatYield(pig));
console.log(FarmBusinessLogic.isEligibleForEggProduction(chicken));
console.log(FarmBusinessLogic.calculateMilkEfficiency(cow));
