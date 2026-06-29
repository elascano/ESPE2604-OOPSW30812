const Cut = require('./Cut');

class Pig {
  constructor(id, breed, bornOn, weight, idealWeight) {
    this.id = id;
    this.type = 'Pig';
    this.breed = breed;
    this.bornOn = bornOn;
    this.weight = weight;
    this.idealWeight = idealWeight;
  }

  isReadyForSlaughter() {
    return this.weight >= this.idealWeight;
  }

  cut() {
    return [
      new Cut(1, 'Loin', 'Pork loin cut', 4.0),
      new Cut(2, 'Bacon', 'Bacon cut', 3.0),
      new Cut(3, 'Ham', 'Ham cut', 6.0)
    ];
  }

  sendToSlaughterHouse(slaughterHouse) {
    console.log(`Sending pig to slaughter house: ${slaughterHouse.name}`);
  }

  food(food) {
    console.log(`Feeding pig with: ${food.description}`);
  }

  toJSON() {
    return {
      id: this.id,
      type: this.type,
      breed: this.breed,
      bornOn: this.bornOn,
      weight: this.weight,
      idealWeight: this.idealWeight,
      isReadyForSlaughter: this.isReadyForSlaughter()
    };
  }
}

module.exports = Pig;