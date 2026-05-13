class Chicken {

    constructor(id, name, color, age, isMolting) {
        this._id = id;
        this._name = name;
        this._color = color;
        this._age = age;
        this._isMolting = isMolting;
    }

    get id() {
        return this._id;
    }

    set id(value) {
        this._id = value;
    }

    get name() {
        return this._name;
    }

    set name(value) {
        this._name = value;
    }

    get color() {
        return this._color;
    }

    set color(value) {
        this._color = value;
    }

    get age() {
        return this._age;
    }

    set age(value) {
        this._age = value;
    }

    get isMolting() {
        return this._isMolting;
    }

    set isMolting(value) {
        this._isMolting = value;
    }

    toString() {
        return "Chicken{id=${this._id}, name=${this._name}, color=${this._color}, age=${this._age}, isMolting=${this._isMolting}}";
    }
}

// Ejemplo de uso (como el main de Java):
const myChicken = new Chicken(1, "Lucy", "White and Brown", 1, true);
console.log(myChicken.toString());