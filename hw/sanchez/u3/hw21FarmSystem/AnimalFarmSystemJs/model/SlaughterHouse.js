class SlaughterHouse {
    constructor(id, name, address, cellphoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
    }

    getId() { return this.id; }
    setId(id) { this.id = id; }
    getName() { return this.name; }
    setName(name) { this.name = name; }
    getAddress() { return this.address; }
    setAddress(address) { this.address = address; }
    getCellphoneNumber() { return this.cellphoneNumber; }
    setCellphoneNumber(cellphoneNumber) { this.cellphoneNumber = cellphoneNumber; }
}

module.exports = SlaughterHouse;