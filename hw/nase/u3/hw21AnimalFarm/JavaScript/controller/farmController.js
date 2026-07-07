const { Pig, Cow } = require('../model/meatAnimals');
const { Chicken, Sheep } = require('../model/produceAnimals');
const { Food, SlaughterHouse } = require('../model/infrastructure');
const FarmView = require('../view/farmView');

class FarmController {
    constructor() {
        this.animals = [
            new Pig(1, "Landrace", "2025-05-10", 85.0, 110.0),
            new Cow(2, "Holstein", "2023-03-15", 450.0, true),
            new Chicken(3, "Leghorn", "2025-11-20", 2.1, false, 6),
            new Sheep(4, "Merino", "2024-01-05", 55.0, "2026-02-10")
        ];
        this.sampleFood = new Food(501, "Premium Balanced Feed");
        this.slaughterHouse = new SlaughterHouse(1, "Camal Central", "Av. Principal 123", "0999999999");
    }

    runFarmOperations() {
        FarmView.showWelcome();

        this.animals.forEach(animal => {
            const animalType = animal.constructor.name;
            const info = {
                id: animal._id,
                type: animalType,
                breed: animal._breed,
                weight: animal._weight,
                ageMonths: animal.getAgeInMonths()
            };

            if (animal instanceof Cow) {
                info.extra = `¿Produces milk?: ${animal.isProducingMilkStatus() ? 'Yes' : 'No'}`;
                FarmView.showAnimalInfo(info);
                FarmView.showActionResult("Milking", `Were obtained ${animal.milk()} liters.`);
            } 
            else if (animal instanceof Chicken) {
                info.extra = `Projected weekly eggs: ${animal._numberOfEggsPerWeek}`;
                FarmView.showAnimalInfo(info);
                FarmView.showActionResult("Position", animal.layAnEgg());
                animal.measureQuantity("Units", 6);
                FarmView.showActionResult("Procedure", animal.procedure());
            } 
            else if (animal instanceof Pig) {
                info.extra = `Ideal weight: ${animal._idealWeight} kg`;
                FarmView.showAnimalInfo(info);
                animal.sendToSlaughterHouse(this.slaughterHouse);
                FarmView.showActionResult("Destination", `Sent to ${animal.slaughterHouse}`);
            } 
            else if (animal instanceof Sheep) {
                FarmView.showAnimalInfo(info);
                animal.measureQuantity("Kilogramos", 4.5);
                FarmView.showActionResult("Procedure", animal.procedure());
            }

            FarmView.showActionResult("Feeding", animal.feed(this.sampleFood));
        });
    }
}

module.exports = FarmController;