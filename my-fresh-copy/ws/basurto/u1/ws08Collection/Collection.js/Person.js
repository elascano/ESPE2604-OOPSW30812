// Jennyfer Nase
export class Person {
    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }
    toString() {
        return `Person{id=${this.id}, fullName=${this.fullName}, bornOnDate=${this.bornOnDate}, alive=${this.alive}}`;
    }
}