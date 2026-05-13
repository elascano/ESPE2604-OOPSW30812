
const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

let name = "Lucy";
let color = "Brown and White";
let age = 2;
let isMolting = false;
let eggCounter = 0;

function showMenu() {
    console.log("\n1. cluck\n2. wander\n3. eat\n4. drink\n5. poop\n6. lay an egg\n7. show state\n0. exit");
    readline.question('Select behavior: ', (option) => {
        switch (option) {
            case "1": console.log(`${name}: Cluck cluck!`); break;
            case "2": console.log(`${name} is wandering around.`); break;
            case "3": console.log(`${name} is eating.`); break;
            case "4": console.log(`${name} is drinking.`); break;
            case "5": console.log(`${name} did poop.`); break;
            case "6": 
                eggCounter++;
                console.log(`${name} laid an egg! Total: ${eggCounter}`); 
                break;
            case "7":
                console.log(`\n--- Chicken State ---\nName: ${name}\nColor: ${color}\nAge: ${age}\nMolting: ${isMolting ? "Yes" : "No"}\nEggs: ${eggCounter}\n---------------------\n`);
                break;
            case "0": 
                console.log("Exiting...");
                readline.close();
                return;
            default: console.log("Invalid option."); break;
        }
        showMenu(); 
    });
}

showMenu();

