import promptSync from "prompt-sync";
import Chicken from "../model/Chicken.js";

const prompt = promptSync();

let chickens = [];
let option = "y";

while (option.toLowerCase() === "y") {

    console.log("\n--- ENTER CHICKEN DATA ---");

    let id = Number(prompt("Id: "));
    let name = prompt("Name: ");
    let color = prompt("Color: ");

    let year = Number(prompt("Year of birth: "));
    let month = Number(prompt("Month (1-12): "));
    let day = Number(prompt("Day: "));

    let bornOnDate = new Date(year, month - 1, day);

    let age = Number(prompt("Age: "));

    let isMoltingInput = prompt("Is molting? (true/false): ").toLowerCase();
    let isMolting = isMoltingInput === "true";

    let chicken = new Chicken(
        id,
        name,
        color,
        bornOnDate,
        age,
        isMolting
    );

    chickens.push(chicken);

    option = prompt("Do you want to add another chicken? (y/n): ");
}

console.log("\n--- CHICKENS LIST ---");

for (let i = 0; i < chickens.length; i++) {
    console.log(`chicken [${i + 1}] --> ${chickens[i].toString()}`);
}