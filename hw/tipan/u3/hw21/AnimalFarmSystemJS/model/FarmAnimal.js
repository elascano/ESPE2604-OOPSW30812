class FarmAnimal {
    constructor(id, breed, bornOn, weight, slaughterHouse, product, cuts) {
        this.id = id;
        this.breed = breed;
        this.bornOn = bornOn;
        this.weight = weight;
        this.slaughterHouse = slaughterHouse;
        this.product = product;
        this.cuts = cuts;
    }

    getAgeInMonths() {
        const today = new Date();

        let months = (today.getFullYear() - this.bornOn.getFullYear()) * 12;
        months += today.getMonth() - this.bornOn.getMonth();

        if (today.getDate() < this.bornOn.getDate()) {
            months--;
        }

        return months;
    }

    feed(food) {
        throw new Error("The method feed() must be implemented.");
    }

    toString() {
        return `FarmAnimal{id=${this.id}, breed=${this.breed}, weight=${this.weight}}`;
    }
}

module.exports = FarmAnimal;