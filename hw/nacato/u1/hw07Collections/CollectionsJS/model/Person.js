class Person {
    #id;
    #fullName;
    #bornOnDate;
    #alive;

    constructor(id, fullName, bornOnDate, alive) {
        this.#id = id;
        this.#fullName = fullName;
        this.#bornOnDate = new Date(bornOnDate); 
        this.#alive = alive;
    }

    computeAge() {
        const currentDate = new Date();
        let age = currentDate.getFullYear() - this.#bornOnDate.getFullYear();
        const monthDifference = currentDate.getMonth() - this.#bornOnDate.getMonth();
        
        if (monthDifference < 0 || (monthDifference === 0 && currentDate.getDate() < this.#bornOnDate.getDate())) {
            age--;
        }
        
        return age;
    }

    toString() {
        let isAlive;
        if (this.#alive) {
            isAlive = "YES";
        } else {
            isAlive = "NO";
        }
        
        const dateString = this.#bornOnDate.toISOString().split('T')[0];
        
        return `Person{id=${this.#id}, fullName=${this.#fullName}, bornOnDate=${dateString}, alive=${this.#alive}}`;
    }

    get id() {
        return this.#id;
    }

    set id(id) {
        this.#id = id;
    }

    get fullName() {
        return this.#fullName;
    }

    set fullName(fullName) {
        this.#fullName = fullName;
    }

    get bornOnDate() {
        return this.#bornOnDate;
    }

    set bornOnDate(bornOnDate) {
        this.#bornOnDate = new Date(bornOnDate);
    }

    get alive() {
        return this.#alive;
    }

    set alive(alive) {
        this.#alive = alive;
    }
}
module.exports = Person;