export class Chicken {
    constructor(name, age, color, id, isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = isMolting;
    }
    getId() {
        return this.id;
    }
    getName() {
        return this.name;
    }
    getColor() {
        return this.color;
    }
    getAge() {
        return this.age;
    }
    getIsMolting() {
        return this.isMolting;
    }
    setId(id) {
        this.id = id;
    }
    setName(name) {
        this.name = name;
    }
    setColor(color) {
        this.color = color;
    }
    setAge(age) {
        this.age = age;
    }
    setIsMolting(isMolting) {
        this.isMolting = isMolting;
    }
    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, age=${this.age}, isMolting=${this.isMolting}}`;
    }
    doStuff(forTime){}
    #cluck(){}
    #wander(){}
    #eat(){}
    #drink(){}
    #poop(){
        return null;
    }
    #layAnEgg(){
        return null;
    }
}