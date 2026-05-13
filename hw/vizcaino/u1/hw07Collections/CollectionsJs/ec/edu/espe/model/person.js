class Person {
    constructor(id, name, bornOnDate, alive) {
        this.id = id;
        this.name = name;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    computeAgeInYears() {
        const today = new Date();
        let age = today.getFullYear() - this.bornOnDate.getFullYear();

        const m = today.getMonth() - this.bornOnDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < this.bornOnDate.getDate())) {
            age--;
        }

        return age;
    }

    toString() {
        return `Person{id=${this.id}, name=${this.name}, bornOnDate=${this.bornOnDate.toISOString().split('T')[0]}, alive=${this.alive}}`;
    }
}

module.exports = Person;