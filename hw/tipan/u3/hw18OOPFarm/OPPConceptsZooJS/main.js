const readline = require("readline");

const Cow = require("./cow");
const Pig = require("./pig");
const Chicken = require("./chicken");
const Sheep = require("./sheep");
const Food = require("./food");
const FarmAnimalDAO = require("./farmAnimalDAO");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function ask(question) {
    return new Promise(resolve => rl.question(question, resolve));
}

(async function () {

    console.log("===== FARM MANAGEMENT SYSTEM =====");

    const id = parseInt(await ask("Enter ID: "));
    const breed = await ask("Enter Breed: ");
    const weight = parseFloat(await ask("Enter Weight: "));

    console.log("\nSelect Animal");
    console.log("1. Cow");
    console.log("2. Pig");
    console.log("3. Chicken");
    console.log("4. Sheep");

    const option = parseInt(await ask("Option: "));

    let animal;

    switch (option) {
        case 1:
            animal = new Cow(id, breed, weight);
            break;
        case 2:
            animal = new Pig(id, breed, weight);
            break;
        case 3:
            animal = new Chicken(id, breed, weight);
            break;
        case 4:
            animal = new Sheep(id, breed, weight);
            break;
        default:
            console.log("Invalid option.");
            rl.close();
            return;
    }

    const grass = new Food(1, "Grass");

    animal.feed(grass);
    animal.born();

    console.log("\n===== BUSINESS RULES =====");
    console.log("Young Animal:", animal.isYoungAnimal());
    console.log("Ready For Sale:", animal.isReadyForSale());
    console.log("Needs More Food:", animal.needsMoreFood());

    const dao = new FarmAnimalDAO();

    await dao.saveAnimal(animal);

    console.log("\n===== ANIMALS IN DATABASE =====");

    const animals = await dao.getAnimals();

    animals.forEach(a => console.log(a));

    rl.close();

})();