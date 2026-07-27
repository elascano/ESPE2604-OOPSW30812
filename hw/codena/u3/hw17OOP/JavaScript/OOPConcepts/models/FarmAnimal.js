class FarmAnimal {

    constructor(id, breed, bornOnDate, weight) {

        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.weight = weight;

    }

    getAgeInMonths() {
        const today = new Date();
        const birth = new Date(this.bornOnDate);

        let months = (today.getFullYear() - birth.getFullYear()) * 12;
        months += today.getMonth() - birth.getMonth();

        if (today.getDate() < birth.getDate()) {
            months--;
        }

        return months;

    }

    feed(food) {
        throw new Error("feed() must be implemented by subclasses");
    }

    toDocument() {
        throw new Error("toDocument() must be implemented by subclasses");
    }

}

module.exports = FarmAnimal;