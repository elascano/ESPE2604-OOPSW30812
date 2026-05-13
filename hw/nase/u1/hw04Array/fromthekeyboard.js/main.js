const Chicken = require('./chicken');
const readline = require('readline');

const rl = readline.createInterface({ input: process.stdin, output: process.stdout });
const ask = (query) => new Promise((resolve) => rl.question(query, resolve));

async function main() {
    let chickens = [];
    console.log("--- Jennyfer Nase ---");

    for (let i = 0; i < 5; i++) {
        console.log(`\n Chicken #${i + 1}`);

        const id = await ask("ID: ");
        const name = await ask("Name: ");
        const color = await ask("Color: ");
        const age = await ask("Age: ");
        const isMoltingStr = await ask("isMolting (true/false): ");

       
        chickens.push(new Chicken(
            parseInt(id), 
            name, 
            color, 
            parseInt(age), 
            isMoltingStr.toLowerCase() === "true"
        ));

        if (i < 4) {
            const resp = await ask("Another? (yes/no): ");
            if (resp.toLowerCase() !== "yes") break;
        }
    }

    console.log("\n--- FINAL RESULTS ---");
    chickens.forEach(c => console.log(c.toString()));
    rl.close();
}

main();