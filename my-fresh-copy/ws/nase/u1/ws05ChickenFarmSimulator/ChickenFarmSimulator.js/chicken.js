// author JEnnyfer NAse
export class Chicken {
    constructor(id, name, color, age, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = molting;
    }
    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, age=${this.age}, isMolting=${this.isMolting}}`;
    }
}
