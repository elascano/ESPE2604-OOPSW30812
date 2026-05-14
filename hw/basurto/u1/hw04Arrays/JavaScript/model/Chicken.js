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
        return `Chicken{
            id=${this.id},
            name=${this.name},
            color=${this.color},
            bornOnDate=${this.bornOnDate.toDateString()},
            age=${this.age},
            isMolting=${this.isMolting}
            }`;
    }
}

export default Chicken;