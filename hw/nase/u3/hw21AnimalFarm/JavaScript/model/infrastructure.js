class SlaughterHouse {
    constructor(id, name, address, cellPhoneNumbers) {
        this._id = id;
        this._name = name;
        this._address = address;
        this._cellPhoneNumbers = cellPhoneNumbers;
    }
}

class Cut {
    constructor(id, description, procedure, weight) {
        this._id = id;
        this._description = description;
        this._procedure = procedure;
        this._weight = weight;
    }
}

class Food {
    constructor(id, description) {
        this._id = id;
        this._description = description;
    }
}

class Product {
    constructor(id, description, unit, quantity) {
        this._id = id;
        this._description = description;
        this._unit = unit;
        this._quantity = quantity;
    }
}

module.exports = { SlaughterHouse, Cut, Food, Product };