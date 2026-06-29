const Cut = require('./Cut');

class Cow {
  constructor(id, breed, bornOn, weight, isProducingMilk) {
    this.id = id;
    this.type = 'Cow';
    this.breed = breed;
    this.bornOn = bornOn;
    this.weight = weight;
    this.isProducingMilk = isProducingMilk;
    this.milkProduced = 0;
  }

  milk() {
    if (this.isProducingMilk) {
      this.milkProduced = 10 + Math.random() * 20;
      return this.milkProduced;
    }
    return 0;
  }

  cut() {
    return [
      new Cut(1, 'Sirloin', 'Sirloin cut', 5.0),
      new Cut(2, 'Rib', 'Rib cut', 3.5),
      new Cut(3, 'Brisket', 'Brisket cut', 4.0)
    ];
  }

  sendToSlaughterHouse(slaughterHouse) {
    console.log(`Sending cow to slaughter house: ${slaughterHouse.name}`);
  }

  food(food) {
    console.log(`Feeding cow with: ${food.description}`);
  }

  toJSON() {
    return {
      id: this.id,
      type: this.type,
      breed: this.breed,
      bornOn: this.bornOn,
      weight: this.weight,
      isProducingMilk: this.isProducingMilk,
      milkProduced: this.milkProduced
    };
  }
}

module.exports = Cow;