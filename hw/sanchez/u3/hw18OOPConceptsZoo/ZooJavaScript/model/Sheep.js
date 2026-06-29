class Sheep {
  constructor(id, breed, bornOn, weight, lastSheering) {
    this.id = id;
    this.type = 'Sheep';
    this.breed = breed;
    this.bornOn = bornOn;
    this.weight = weight;
    this.lastSheering = lastSheering;
  }

  food(food) {
    console.log(`Feeding sheep with: ${food.description}`);
  }

  toJSON() {
    return {
      id: this.id,
      type: this.type,
      breed: this.breed,
      bornOn: this.bornOn,
      weight: this.weight,
      lastSheering: this.lastSheering
    };
  }
}

module.exports = Sheep;