class Cut {

    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }

    toString() {
        return `${this.name} (${this.weight} kg)`;
    }

}

module.exports = Cut;