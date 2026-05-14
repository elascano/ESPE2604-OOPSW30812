// author JEnnyfer NAse
import { Chicken } from './chicken.js';
import { ChickenCoop } from './coop.js';
import { ChickenFarmer } from './chicken_farmer.js';

function main() {
    const farmer = new ChickenFarmer("Jennyfer Nase");

    const lucy = new Chicken(1, "Lucy", "White and Brown", 1, true);

    const coop = new ChickenCoop(1);
    coop.addChicken(lucy);

    console.log(`My Chicken is ---->${lucy.toString()}`);
}

main();