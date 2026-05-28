/* 
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

class Chicken {
    constructor(id, name, color, bornOnDate, age, isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.age = age;
        this.isMolting = isMolting;
    }

    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate}, age=${this.age}, isMolting=${this.isMolting}}`;
    }

    getId() { return this.id; }
    getName() { return this.name; }
    getColor() { return this.color; }
    getBornOnDate() { return this.bornOnDate; }
    getAge() { return this.age; }
    isIsMolting() { return this.isMolting; }

    setId(id) { this.id = id; }
    setName(name) { this.name = name; }
    setColor(color) { this.color = color; }
    setBornOnDate(bornOnDate) { this.bornOnDate = bornOnDate; }
    setAge(age) { this.age = age; }
    setIsMolting(isMolting) { this.isMolting = isMolting; }
}

export default Chicken;