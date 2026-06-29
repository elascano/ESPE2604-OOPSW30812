import readline from "readline";
import { Food } from "../model/Food.js";
import { SlaughterHouse } from "../model/SlaughterHouse.js";
import { Chicken } from "../model/Chicken.js";
import { Cow } from "../model/Cow.js";
import { Pig } from "../model/Pig.js";
import { Sheep } from "../model/Sheep.js";

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const question = (query) => new Promise((resolve) => rl.question(query, resolve));

async function main() {
    const today = new Date();

    console.log("--- Register Food ---");
    const foodId = parseInt(await question("Enter food ID: "));
    const foodDescription = await question("Enter food description: ");
    const food = new Food(foodId, foodDescription);

    console.log("\n--- Register Slaughterhouse ---");
    const slaughterhouseDescription = await question("Enter slaughterhouse description: ");
    const slaughterhouse = new SlaughterHouse(slaughterhouseDescription);

    console.log("\n--- Register Chicken ---");
    const chickenId = parseInt(await question("Enter chicken ID: "));
    const chickenBreed = await question("Enter chicken breed: ");
    const chickenWeight = parseFloat(await question("Enter chicken weight: "));
    const isMolting = (await question("Is the chicken molting? (true/false): ")).toLowerCase() === "true";
    const eggsPerWeek = parseInt(await question("Enter number of eggs per week: "));
    const chicken = new Chicken(chickenId, chickenBreed, today, chickenWeight, isMolting, eggsPerWeek);

    console.log("\n--- Register Cow ---");
    const cowId = parseInt(await question("Enter cow ID: "));
    const cowBreed = await question("Enter cow breed: ");
    const cowWeight = parseFloat(await question("Enter cow weight: "));
    const isProducingMilk = (await question("Is the cow producing milk? (true/false): ")).toLowerCase() === "true";
    const milkLiters = parseFloat(await question("Enter milk liters: "));
    const cow = new Cow(cowId, cowBreed, today, cowWeight, isProducingMilk, milkLiters);

    console.log("\n--- Register Pig ---");
    const pigId = parseInt(await question("Enter pig ID: "));
    const pigBreed = await question("Enter pig breed: ");
    const pigWeight = parseFloat(await question("Enter pig weight: "));
    const pigIdealWeight = parseFloat(await question("Enter pig ideal weight: "));
    const pig = new Pig(pigId, pigBreed, today, pigWeight, pigIdealWeight);

    console.log("\n--- Register Sheep ---");
    const sheepId = parseInt(await question("Enter sheep ID: "));
    const sheepBreed = await question("Enter sheep breed: ");
    const sheepWeight = parseFloat(await question("Enter sheep weight: "));
    const sheep = new Sheep(sheepId, sheepBreed, today, sheepWeight, today);

    console.log("\n--- Execution Outputs ---");
    chicken.feed(food);
    chicken.layAnEgg();

    console.log(`Cow producing milk: ${cow.isProducingMilk} (${cow.milk()}L)`);
    cow.sendToSlaughterHouse(slaughterhouse);

    const cowCuts = cow.cut();
    cowCuts.forEach(cut => {
        console.log(`Obtained Cut: ${cut.description} - Weight: ${cut.weight}kg`);
    });

    pig.sendToButcher();

    rl.close();
}

main();