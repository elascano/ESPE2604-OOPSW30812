class FarmAnimal {
    constructor(id, breed, bornOnDate, weight, slaughterHouse, product, cuts) {

        if (new.target === FarmAnimal) {
            throw new Error("FarmAnimal is an abstract class.");
        }

        this.id = id
        this.breed = breed
        this.bornOnDate = bornOnDate
        this.weight = weight
        this.slaughterHouse = slaughterHouse
        this.product = product
        this.cuts = cuts
    }


    getAgeInMonths() {
        if (this.bornOnDate == null) {
            throw new Error("bornOnDate cannot be null");
        }

        const currentDate = new Date();

        let months =
            (currentDate.getFullYear() - this.bornOnDate.getFullYear()) * 12 +
            (currentDate.getMonth() - this.bornOnDate.getMonth());

        if (currentDate.getDate() < this.bornOnDate.getDate()) {
            months--;
        }

        return months;
    }


    feed(food) {
        throw new Error("The method feed() must be implemented.");
    }


}