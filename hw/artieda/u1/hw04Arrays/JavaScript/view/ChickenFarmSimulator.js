import promptSync from "prompt-sync";
import Chicken from "../model/Chicken.js";

const input = promptSync();

const chickens = [];

let continueProgram = true;

while (continueProgram) {

    console.log("\n=== REGISTER CHICKEN ===");

    const code = parseInt(input("Code: "));
    const breed = input("Breed: ");
    const weight = parseFloat(input("Weight: "));

    const year = parseInt(input("Birth year: "));
    const month = parseInt(input("Birth month: "));
    const day = parseInt(input("Birth day: "));

    const birthDate = new Date(year, month - 1, day);

    const vaccinatedText = input("Vaccinated (yes/no): ").toLowerCase();
    const vaccinated = vaccinatedText === "yes";

    const newChicken = new Chicken(
        code,
        breed,
        weight,
        birthDate,
        vaccinated
    );

    chickens.push(newChicken);

    const answer = input("Add another chicken? (yes/no): ").toLowerCase();

    if (answer !== "yes") {
        continueProgram = false;
    }
}

console.log("\n=== REGISTERED CHICKENS ===");

chickens.forEach((chicken, index) => {
    console.log(`\nChicken ${index + 1}`);
    console.log(chicken.showData());
});