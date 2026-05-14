class Chicken {

    constructor(code, type, weight, birthDate, vaccinated) {
        this.code = code;
        this.type = type;
        this.weight = weight;
        this.birthDate = birthDate;
        this.vaccinated = vaccinated;
    }

    showData() {
        return `Chicken:
        Code: ${this.code}
        Type: ${this.type}
        Weight: ${this.weight}
        Birth Date: ${this.birthDate.toDateString()}
        Vaccinated: ${this.vaccinated}`;
    }
}

export default Chicken;