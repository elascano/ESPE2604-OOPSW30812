
const BubbleSort = require("../strategy/BubbleSort");
const InsertionSort = require("../strategy/InsertionSort");
const QuickSort = require("../strategy/QuickSort");
class SortingContext {

    constructor() {
        this.strategy = null;
    }

    setStrategy(strategy) {
        this.strategy = strategy;
    }

    sort(array) {

        if (array.length >= 2 && array.length <= 6) {
            this.setStrategy(new BubbleSort());

        } else if (array.length >= 7 && array.length <= 10) {
            this.setStrategy(new InsertionSort());

        } else  if (array.length >=11) {
            this.setStrategy(new QuickSort());
        }

        return {
            algorithm: this.strategy.constructor.name,
            sortedArray: this.strategy.sort(array)
        };
    }

}

module.exports = SortingContext;