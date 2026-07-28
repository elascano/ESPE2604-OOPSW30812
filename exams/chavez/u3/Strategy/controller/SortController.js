const ArrayModel = require("../model/ArrayModel");
const SortingContext = require("../strategy/SortingContext");
const ArrayRepository = require("../database/ArrayRepository");

class SortController {

    constructor() {
        this.context = new SortingContext();
        this.repository = new ArrayRepository();
    }

    async sort(numbers) {

        const model = new ArrayModel(numbers);

        const result = this.context.sort(model.getNumbers());

        model.setAlgorithm(result.algorithm);
        model.setSortedNumbers(result.sortedArray);

        await this.repository.save(model);

        return model;
    }
}

module.exports = SortController;