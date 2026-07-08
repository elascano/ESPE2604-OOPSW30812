export class IMeatAnimal {
    cut() {
        throw new Error('Method cut() must be implemented');
    }
    
    sendToSlaughterHouse(slaughterHouse) {
        throw new Error('Method sendToSlaughterHouse() must be implemented');
    }
    
    isReadyForSlaughter() {
        throw new Error('Method isReadyForSlaughter() must be implemented');
    }
}