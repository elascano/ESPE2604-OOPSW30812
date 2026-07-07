const AnimalController = require('../controller/AnimalController');

class AnimalView {
    displayHeader(title) {
        console.log(`       ${title}`);
        console.log();
    }

    displayFooter() {
        console.log();
        console.log("       SYSTEM COMPLETED");
    }

    displayAnimal(animal, title) {
        console.log(`--- ${title} ---`);
        console.log(`ID: ${animal.getId()}`);
        console.log(`Breed: ${animal.getBreed()}`);
        console.log(`Weight: ${animal.getWeight()} kg`);
        
        if (typeof animal.getAgeInMonths === 'function') {
            console.log(`Age: ${animal.getAgeInMonths()} months`);
        }
        
        if (typeof animal.isProducingMilk === 'function') {
            console.log(`Producing milk? ${animal.isProducingMilk()}`);
        }
        
        if (typeof animal.getIdealWeight === 'function') {
            console.log(`Ideal weight: ${animal.getIdealWeight()} kg`);
        }
        
        if (typeof animal.isIsMolting === 'function') {
            console.log(`Is molting? ${animal.isIsMolting()}`);
            console.log(`Eggs per week: ${animal.getNumberOfEggsPerWeek()}`);
        }
        
        if (typeof animal.getKgOfWool === 'function') {
            console.log(`Wool: ${animal.getKgOfWool()} kg`);
        }
        
        if (animal.getSlaughterHouse() && animal.getSlaughterHouse().getName()) {
            console.log(`Slaughterhouse: ${animal.getSlaughterHouse().getName()}`);
        }
        console.log();
    }

    displayProduct(product, message) {
        if (product) {
            console.log(`${message}: ${product.getQuantity()} ${product.getUnit()}`);
        } else {
            console.log(`${message}: No product available`);
        }
    }

    displayCuts(cuts, title) {
        console.log(title);
        console.log("Cuts");
        if (cuts && cuts.length > 0) {
            for (const cut of cuts) {
                console.log(`  ${cut.getDescription()} - ${cut.getProcedure()} - ${cut.getWeight()} kg`);
            }
        } else {
            console.log("  No cuts available");
        }
        console.log();
    }

    displayMessage(message) {
        console.log(message);
    }

    displaySeparator() {
        console.log("----------------------------------------");
    }

    displayAnimalSummary(animals) {
        console.log("         ANIMALS REGISTERED");
        console.log();
        console.log(`Total animals: ${animals.length}`);
        console.log("----------------------------------------");
        
        const cows = animals.filter(a => a.constructor.name === 'Cow');
        const pigs = animals.filter(a => a.constructor.name === 'Pig');
        const chickens = animals.filter(a => a.constructor.name === 'Chicken');
        const sheeps = animals.filter(a => a.constructor.name === 'Sheep');
        
        if (cows.length > 0) console.log(`Cows: ${cows.length}`);
        if (pigs.length > 0) console.log(`Pigs: ${pigs.length}`);
        if (chickens.length > 0) console.log(`Chickens: ${chickens.length}`);
        if (sheeps.length > 0) console.log(`Sheep: ${sheeps.length}`);
        
        console.log("----------------------------------------");
        for (const animal of animals) {
            const type = animal.constructor.name;
            console.log(`${type} - ${animal.getBreed()} - ${animal.getWeight()} kg`);
        }
        console.log();
    }

    run() {
        const controller = new AnimalController();
        
        this.displayHeader("ANIMAL FARM SYSTEM");
        
        const animals = controller.getAllAnimals();
        
        const cow1 = animals[0];
        this.displayAnimal(cow1, "COW 1: DAIRY COW");
        const milk = controller.produceProduct(cow1.getId());
        this.displayProduct(milk, "Product");
        console.log();
        
        const cow2 = animals[1];
        this.displayAnimal(cow2, "COW 2: MEAT COW");
        const beefCuts = controller.getCuts(cow2.getId());
        this.displayCuts(beefCuts, "BEEF CUTS");
        
        const pig1 = animals[2];
        this.displayAnimal(pig1, "PIG 1");
        const porkCuts1 = controller.getCuts(pig1.getId());
        this.displayCuts(porkCuts1, "PORK CUTS");
        
        const pig2 = animals[3];
        this.displayAnimal(pig2, "PIG 2");
        const porkCuts2 = controller.getCuts(pig2.getId());
        this.displayCuts(porkCuts2, "PORK CUTS");
        
        const chicken = animals[4];
        this.displayAnimal(chicken, "CHICKEN");
        const laid = controller.layEgg(chicken.getId());
        this.displayMessage(laid ? "The chicken laid an egg!" : "The chicken could not lay an egg.");
        this.displayMessage(`Eggs per week: ${chicken.getNumberOfEggsPerWeek()}`);
        console.log();
        const eggs = controller.produceProduct(chicken.getId());
        this.displayProduct(eggs, "Eggs produced");
        console.log();
        
        const sheep = animals[5];
        this.displayAnimal(sheep, "SHEEP");
        const wool = controller.shearSheep(sheep.getId());
        this.displayMessage(`Wool obtained: ${wool} kg`);
        console.log();
        const woolProduct = controller.produceProduct(sheep.getId());
        this.displayProduct(woolProduct, "Wool produced");
        console.log();
        
        this.displayAnimalSummary(animals);
        this.displayFooter();
    }
}

const view = new AnimalView();
view.run();