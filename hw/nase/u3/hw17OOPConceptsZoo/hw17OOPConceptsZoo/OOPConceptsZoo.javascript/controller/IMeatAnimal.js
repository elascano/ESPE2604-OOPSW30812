export class IMeatAnimal {
    cut() {
        throw new Error("Method 'cut()' must be implemented.");
    }

    sendToSlaughterHouse(slaughterhouse) {
        throw new Error("Method 'sendToSlaughterHouse()' must be implemented.");
    }
}