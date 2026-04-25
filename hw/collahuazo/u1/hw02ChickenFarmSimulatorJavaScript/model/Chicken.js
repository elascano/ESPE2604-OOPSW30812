export class Chicken {
    #id
    #name
    #color
    #age
    #isMolting
    constructor(id, name, color, age, isMolting) {
        this.id = id
        this.name=name
        this.color=color
        this.age=age
        this.isMolting=isMolting

    }

    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, age=${this.age}, isMolting=${this.isMolting}}`;
    }
    get id() {
        return this.#id;
    }

    set id(id) {
        this.#id = id;
    }
    get name() {
        return this.#name;
    }

    set name(name) {
        this.#name = name;
    }
    get color() {
        return this.#color;
    }

    set color(color) {
        this.#color = color;
    }
    get age() {
        return this.#age;
    }

    set age(age) {
        this.#age = age;
    }
    get isMolting() {
        return this.#isMolting;
    }

    set isMolting(isMolting) {
        this.#isMolting = isMolting;
    }
}
