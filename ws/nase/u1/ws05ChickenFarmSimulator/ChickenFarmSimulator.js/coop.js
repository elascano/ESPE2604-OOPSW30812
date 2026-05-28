// author JEnnyfer NAse
export class ChickenCoop {
    constructor(id) {
        this.id = id;
        this.chickens = [];
    }

    addChicken(chicken) {
        this.chickens.push(chicken);
    }
}