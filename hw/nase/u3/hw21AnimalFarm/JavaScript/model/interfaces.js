class IMeatAnimal {
    cut() { throw new Error("The 'cut()' method must be implemented.."); }
    sendToSlaughterHouse(slaughterHouse) { throw new Error("Método 'sendToSlaughterHouse()' must be implemented."); }
}

class IProduceAnimal {
    procedure() { throw new Error("Método 'procedure()' must be implemented."); }
    measureQuantity(unit, quantity) { throw new Error("Método 'measureQuantity()' must be implemented."); }
}

module.exports = { IMeatAnimal, IProduceAnimal };