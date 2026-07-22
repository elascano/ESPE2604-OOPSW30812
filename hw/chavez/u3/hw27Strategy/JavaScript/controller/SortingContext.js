const BubbleSort = require("../model/BubbleSort");
const InsertionSort = require("../model/InsertionSort");
const QuickSort = require("../model/QuickSort");

class SortingContext {

    sort(data) {

        let strategy;

        if (data.length < 30) {
            strategy = new BubbleSort();
        } else if (data.length < 100) {
            strategy = new InsertionSort();
        } else {
            strategy = new QuickSort();
        }

        return strategy.sort(data);
    }

}

module.exports = SortingContext;
