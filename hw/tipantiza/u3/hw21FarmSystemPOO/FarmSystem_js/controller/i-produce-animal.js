export class IProduceAnimal {
    produce() {
        throw new Error('Method produce() must be implemented');
    }
    
    measureQuantity(unit, quantity) {
        throw new Error('Method measureQuantity() must be implemented');
    }
}