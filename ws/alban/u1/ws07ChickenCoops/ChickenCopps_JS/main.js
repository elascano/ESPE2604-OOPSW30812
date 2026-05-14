import { Chicken } from './ec.edu.espe.ChickenCopps.model/Chicken.js';
import { ChickenFarmSimulator } from './ec.edu.espe.ChickenCopps.view/ChickenFarmSimulator.js';
import readline from 'readline';

const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const ask = (query) => new Promise((resolve) => rl.question(query, resolve));

async function main() {
    let chickens = new Array(5).fill(null);
    let count = 0;

   
    while (count < 5) {
        console.log(`\nEntering data for chicken ${count + 1}`);
        const id = parseInt(await ask('ID: '));
        const name = await ask('Name: ');
        const color = await ask('Color: ');
        const age = parseInt(await ask('Age: '));
        const isMolting = (await ask('Is Molting? (true/false): ')).toLowerCase() === 'true';

        chickens[count] = new Chicken(id, name, color, new Date(), age, isMolting);
        count++;

        if (count < 5) {
            const opt = (await ask('Do you want to enter another? (s/n): ')).toLowerCase();
            if (opt !== 's') break;
        }
    }

  
    const defaults = [
        [1, "Lucy", "brown and white", 0, false],
        [2, "Christopher Lomas", "Red", 0, false],
        [3, "Andres Lomas", "White", 0, true],
        [4, "Jonathan Lomas", "Yellow", 0, true]
    ];

    for (let d of defaults) {
        if (count < 5) {
            chickens[count] = new Chicken(d[0], d[1], d[2], new Date(), d[3], d[4]);
            count++;
        }
    }


    ChickenFarmSimulator.display(chickens, count);
    rl.close();
}

main();


