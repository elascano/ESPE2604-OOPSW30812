class Chicken {
  constructor(id, breed, bornOn, weight, isMolting) {
    this.id = id;
    this.type = 'Chicken';
    this.breed = breed;
    this.bornOn = bornOn;
    this.weight = weight;
    this.isMolting = isMolting;
    this.numberOfEggsPerWeek = 0;
  }

  layAnEgg() {
    if (!this.isMolting) {
      this.numberOfEggsPerWeek++;
      return 1;
    }
    return 0;
  }

  food(food) {
    console.log(`Feeding chicken with: ${food.description}`);
  }

  toJSON() {
    return {
      id: this.id,
      type: this.type,
      breed: this.breed,
      bornOn: this.bornOn,
      weight: this.weight,
      isMolting: this.isMolting,
      numberOfEggsPerWeek: this.numberOfEggsPerWeek
    };
  }
}

module.exports = Chicken;