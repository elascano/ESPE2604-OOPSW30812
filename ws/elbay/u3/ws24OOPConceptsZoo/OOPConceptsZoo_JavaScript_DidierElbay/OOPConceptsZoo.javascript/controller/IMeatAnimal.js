/**
 * IMeatAnimal - Abstract contract for animals that can be processed for meat.
 * Subclasses must implement cut() and sendToSlaughterHouse().
 * @author Didier Elbay
 */
export class IMeatAnimal {
    cut() {
        throw new Error("Method 'cut()' must be implemented.");
    }

    sendToSlaughterHouse(slaughterhouse) {
        throw new Error("Method 'sendToSlaughterHouse()' must be implemented.");
    }
}
