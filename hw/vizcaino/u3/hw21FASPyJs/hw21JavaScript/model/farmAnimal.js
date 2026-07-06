export class FarmAnimal {
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
        if (!this.bornOn) {
            throw new Error("bornOn is not set");
        }

        const today = new Date();

        if (this.bornOn > today) {
            throw new Error("bornOn cannot be in the future");
        }

        return (
            (today.getFullYear() - this.bornOn.getFullYear()) * 12 +
            (today.getMonth() - this.bornOn.getMonth())
        );
    }

    feed(food) {
        throw new Error("Method not implemented");
    }

    toString() {
        return `FarmAnimal{id=${this.id}, breed=${this.breed}, bornOn=${this.bornOn.toDateString()}, weight=${this.weight}}`;
    }
}