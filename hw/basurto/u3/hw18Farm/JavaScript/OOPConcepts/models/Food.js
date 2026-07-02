class Food {

    constructor(id, typeOfFood) {
        this.id = id;
        this.typeOfFood = typeOfFood;
    }

    toDocument() {
        return {_id: this.id,typeOfFood: this.typeOfFood};
    }

}

module.exports = Food;