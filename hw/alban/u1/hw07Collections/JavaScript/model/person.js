class Person {

    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    computeAgeInYears() {

        const currentDate = new Date();

        let age =
            currentDate.getFullYear() -
            this.bornOnDate.getFullYear();

        const monthDifference =
            currentDate.getMonth() -
            this.bornOnDate.getMonth();

        if (
            monthDifference < 0 ||
            (
                monthDifference === 0 &&
                currentDate.getDate() <
                this.bornOnDate.getDate()
            )
        ) {
            age--;
        }

        return age;
    }

    toString() {

        const isAlive =
            this.alive ? "YES" : "NO";

        return `Person ${this.id} --> Name:${this.fullName}, ` +
               `BirthDate:${this.bornOnDate.toDateString()}, ` +
               `alive:${isAlive} <--`;
    }
}

module.exports = Person;