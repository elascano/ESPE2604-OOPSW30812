/* author: Didier Elbay */
class Chicken {
    constructor(id, name, color, age, isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = isMolting;
    }

    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, age=${this.age}, isMolting=${this.isMolting}}`;
    }
}

function main() {
    console.log("--- Chicken Farm Simulator (JavaScript) ---");
    let lucy = new Chicken(1, "Lucy", "Brown", 1, false);
    console.log(lucy.toString());
}

main();