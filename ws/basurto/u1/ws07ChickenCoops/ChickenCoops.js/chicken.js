//author Jennyfer Nase
export class Chicken {
    constructor(id, name, color, age, molting, bornOnDate) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.age = age;
        this.isMolting = molting;
    }
    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate}, age=${this.age}, IsMolting=${this.isMolting}}`;
    }
}