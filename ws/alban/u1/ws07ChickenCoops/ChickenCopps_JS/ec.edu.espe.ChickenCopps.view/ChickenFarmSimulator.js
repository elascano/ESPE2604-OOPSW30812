import { Chicken } from '../ec.edu.espe.ChickenCopps.model/Chicken.js';

export class ChickenFarmSimulator {
    static display(chickens, count) {
        console.log("\n" + "=".repeat(40));
        console.log("Quiz 26-4-2026 CHRISTOPHER LOMAS");
        console.log("=".repeat(40));

        for (let i = 0; i < count; i++) {
            if (chickens[i]) {
                chickens[i].id = i + 1; // Ajuste de ID como en tu Java
                console.log(`name---> ${chickens[i].name}`);
                console.log(`chicken [${i + 1}] ${chickens[i].toString()}`);
            }
        }
    }
}

