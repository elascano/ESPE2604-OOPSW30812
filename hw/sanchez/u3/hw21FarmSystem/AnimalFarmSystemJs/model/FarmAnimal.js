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
        if (!this.bornOn) {
            throw new Error("The birth date has not been assigned.");
        }
        const birthDate = new Date(this.bornOn);
        const today = new Date();
        if (birthDate > today) {
            throw new Error("The birth date cannot be in the future.");
        }
        const months = (today.getFullYear() - birthDate.getFullYear()) * 12;
        return months + (today.getMonth() - birthDate.getMonth());
    }

    feed(food) {
        throw new Error("Method 'feed' must be implemented");
    }

    getId() { return this.id; }
    setId(id) { this.id = id; }
    getBreed() { return this.breed; }
    setBreed(breed) { this.breed = breed; }
    getBornOn() { return this.bornOn; }
    setBornOn(bornOn) { this.bornOn = bornOn; }
    getWeight() { return this.weight; }
    setWeight(weight) { this.weight = weight; }
    getSlaughterHouse() { return this.slaughterHouse; }
    setSlaughterHouse(slaughterHouse) { this.slaughterHouse = slaughterHouse; }
    getProduct() { return this.product; }
    setProduct(product) { this.product = product; }
    getCuts() { return this.cuts; }
    setCuts(cuts) { this.cuts = cuts; }
}

module.exports = FarmAnimal;