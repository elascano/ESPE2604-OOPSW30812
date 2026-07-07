class SlaughterHouse {
    constructor(id, name, address, cellphoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
    }

    toString() {
        return `SlaughterHouse{id=${this.id}, name=${this.name}, address=${this.address}, cellphoneNumber=${this.cellphoneNumber}}`;
    }
}

module.exports = SlaughterHouse;