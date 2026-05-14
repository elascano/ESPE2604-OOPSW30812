const prompt = require("prompt-sync")();

const Chicken =
require("../model/Chicken");

const chickens = [];

for (let i = 0; i < 2; i++) {

    console.log(
        `\nEnter data for chicken ${i + 1}`
    );

    const id = parseInt(
        prompt("Id: ")
    );

    const name = prompt("Name: ");

    const color = prompt("Color: ");

    const age = parseInt(
        prompt("Age: ")
    );

    const isMolting =
        prompt("Is molting (true/false): ")
        === "true";

    const chicken = new Chicken(
        id,
        name,
        color,
        new Date(),
        age,
        isMolting
    );

    chickens.push(chicken);
}

console.log("\n--- CHICKENS DATA ---");

for (const chicken of chickens) {

    console.log(chicken.toString());
}