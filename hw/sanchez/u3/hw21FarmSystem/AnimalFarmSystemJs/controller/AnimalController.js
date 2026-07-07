const Cow = require('../model/Cow');
const Pig = require('../model/Pig');
const Chicken = require('../model/Chicken');
const Sheep = require('../model/Sheep');
const SlaughterHouse = require('../model/SlaughterHouse');
const Food = require('../model/Food');

class AnimalController {
    constructor() {
        this.slaughterHouse = new SlaughterHouse(1, "Central Slaughterhouse", "123 Main St", "555-1234");
        this.animals = [];
        this.foods = [
            new Food(1, "Grass"),
            new Food(2, "Grain"),
            new Food(3, "Mixed Feed")
        ];
        this.initializeAnimals();
    }

    initializeAnimals() {
        const cow1 = new Cow(true, 1, "Holstein", new Date(), 450.0, null, null, null);
        const cow2 = new Cow(false, 2, "Angus", new Date(), 520.0, this.slaughterHouse, null, null);
        const pig1 = new Pig(120.0, 3, "Duroc", new Date(), 80.0, this.slaughterHouse, null, null);
        const pig2 = new Pig(110.0, 4, "Berkshire", new Date(), 95.0, this.slaughterHouse, null, null);
        const chicken = new Chicken(false, 7, 5, "Leghorn", new Date(), 2.5, this.slaughterHouse, null, null);
        const sheep = new Sheep(new Date(), 3.5, 6, "Merino", new Date(), 70.0, this.slaughterHouse, null, null);

        this.animals = [cow1, cow2, pig1, pig2, chicken, sheep];
    }

    getAllAnimals() {
        return this.animals;
    }

    getAnimalById(id) {
        return this.animals.find(animal => animal.getId() === id);
    }

    getCows() {
        return this.animals.filter(animal => animal instanceof Cow);
    }

    getPigs() {
        return this.animals.filter(animal => animal instanceof Pig);
    }

    getChickens() {
        return this.animals.filter(animal => animal instanceof Chicken);
    }

    getSheep() {
        return this.animals.filter(animal => animal instanceof Sheep);
    }

    feedAnimal(animalId, foodId) {
        const animal = this.getAnimalById(animalId);
        const food = this.foods.find(f => f.getId() === foodId);
        if (animal && food) {
            animal.feed(food);
            return true;
        }
        return false;
    }

    produceProduct(animalId) {
        const animal = this.getAnimalById(animalId);
        if (animal && animal.produce) {
            return animal.produce();
        }
        return null;
    }

    getCuts(animalId) {
        const animal = this.getAnimalById(animalId);
        if (animal && animal.cut) {
            return animal.cut();
        }
        return null;
    }

    sendToSlaughterHouse(animalId) {
        const animal = this.getAnimalById(animalId);
        if (animal && animal.sendToSlaughterHouse) {
            animal.sendToSlaughterHouse(this.slaughterHouse);
            return true;
        }
        return false;
    }

    layEgg(animalId) {
        const animal = this.getAnimalById(animalId);
        if (animal instanceof Chicken && animal.layAnEgg) {
            return animal.layAnEgg();
        }
        return false;
    }

    shearSheep(animalId) {
        const animal = this.getAnimalById(animalId);
        if (animal instanceof Sheep && animal.shear) {
            return animal.shear();
        }
        return null;
    }

    getSlaughterHouse() {
        return this.slaughterHouse;
    }

    getFoods() {
        return this.foods;
    }
}

module.exports = AnimalController;