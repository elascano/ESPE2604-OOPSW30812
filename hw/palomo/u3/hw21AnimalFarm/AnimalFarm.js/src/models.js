import { MongoConnection } from "./controller.js";

class Cut {
  constructor(id, description, procedure, weight) {
    this.id = id;
    this.description = description;
    this.procedure = procedure;
    this.weight = weight;
  }

  getId() { return this.id; }
  getDescription() { return this.description; }
  getProcedure() { return this.procedure; }
  getWeight() { return this.weight; }
}

class Food {
  constructor(id, description) {
    this.id = id;
    this.description = description;
  }

  getId() { return this.id; }
  getDescription() { return this.description; }
}

class SlaughterHouse {
  constructor(description) {
    this.description = description;
  }

  getDescription() { return this.description; }
}

class FarmAnimal {
  constructor(id, breed, bornOn, weight) {
    this.id = id;
    this.breed = breed;
    this.bornOn = bornOn;
    this.weight = weight;
  }

  getAgeInMonths() { return 12; }

  feed(food) {
    console.log(`Animal ${this.id} fed.`);
  }

  getId() { return this.id; }
  getBreed() { return this.breed; }
  getBornOn() { return this.bornOn; }
  getWeight() { return this.weight; }
}

class Cow extends FarmAnimal {
  constructor(id, breed, bornOn, weight, isProducingMilk, milk) {
    super(id, breed, bornOn, weight);
    this.producingMilk = isProducingMilk;
    this.milkAmount = milk;
  }

  cut() {
    return [
      new Cut(10, "T-Bone", "Rib Section", this.getWeight() * 0.20),
      new Cut(11, "Ribeye", "Loin Section", this.getWeight() * 0.12),
    ];
  }

  sendToSlaughterHouse(slaughterHouse) {
    console.log("Cow moving to house.");
  }

  async saveToDatabase() {
    const document = {
      id: this.getId(),
      breed: this.getBreed(),
      bornOn: this.getBornOn(),
      weight: this.getWeight(),
      isProducingMilk: this.producingMilk,
      milk: this.milkAmount,
    };
    await MongoConnection.saveDocument("cows", document);
  }

  isProducingMilk() { return this.producingMilk; }
  milk() { return this.milkAmount; }
}

class Pig extends FarmAnimal {
  constructor(id, breed, bornOn, weight, idealWeight) {
    super(id, breed, bornOn, weight);
    this.idealWeight = idealWeight;
  }

  cut() {
    return [
      new Cut(1, "Pork Chop", "Standard Cut", this.getWeight() * 0.15),
      new Cut(2, "Ribs", "Rib Extraction", this.getWeight() * 0.10),
    ];
  }

  sendToSlaughterHouse(slaughterHouse) {
    console.log("Pig moving to house.");
  }

  async saveToDatabase() {
    const document = {
      id: this.getId(),
      breed: this.getBreed(),
      bornOn: this.getBornOn(),
      weight: this.getWeight(),
      idealWeight: this.idealWeight,
    };
    await MongoConnection.saveDocument("pigs", document);
  }

  getIdealWeight() { return this.idealWeight; }
}

class Sheep extends FarmAnimal {
  constructor(id, breed, bornOn, weight, lastSheering) {
    super(id, breed, bornOn, weight);
    this.lastSheering = lastSheering;
  }

  async saveToDatabase() {
    const document = {
      id: this.getId(),
      breed: this.getBreed(),
      bornOn: this.getBornOn(),
      weight: this.getWeight(),
      lastSheering: this.lastSheering,
    };
    await MongoConnection.saveDocument("sheeps", document);
  }

  getLastSheering() { return this.lastSheering; }
}

class Chicken extends FarmAnimal {
  constructor(id, breed, bornOn, weight, isMolting, numberOfEggsPerWeek) {
    super(id, breed, bornOn, weight);
    this.molting = isMolting;
    this.numberOfEggsPerWeek = numberOfEggsPerWeek;
  }

  layAnEgg() {
    console.log("Egg laid.");
  }

  async saveToDatabase() {
    const document = {
      id: this.getId(),
      breed: this.getBreed(),
      bornOn: this.getBornOn(),
      weight: this.getWeight(),
      isMolting: this.molting,
      numberOfEggsPerWeek: this.numberOfEggsPerWeek,
    };
    await MongoConnection.saveDocument("chickens", document);
  }

  isMolting() { return this.molting; }
  getNumberOfEggsPerWeek() { return this.numberOfEggsPerWeek; }
}

export { Cut, Food, SlaughterHouse, FarmAnimal, Cow, Pig, Sheep, Chicken };
