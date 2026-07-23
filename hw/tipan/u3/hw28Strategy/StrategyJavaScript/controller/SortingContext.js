const BubbleSort = require("../model/BubbleSort");
const InsertionSort = require("../model/InsertionSort");
const QuickSort = require("../model/QuickSort");

class SortingContext {

    constructor() {
        this.sortingStrategy = null;
    }

    sort(data) {

        this.sortingStrategy = this.setSortStrategy(data.length);

        return this.sortingStrategy.sort(data);

    }

    setSortStrategy(size) {

        if (size > 0 && size < 30) {

            this.sortingStrategy = new BubbleSort();

        } else if (size >= 30 && size < 100) {

            this.sortingStrategy = new InsertionSort();

        } else {

            this.sortingStrategy = new QuickSort();

        }

        return this.sortingStrategy;

    }

}

module.exports = SortingContext;