const SortingContext = require("../controller/SortingContext");
const BubbleSort = require("../model/BubbleSort");
const InsertionSort = require("../model/InsertionSort");
const QuickSort = require("../model/QuickSort");

class SortApp {

    static printArray(data) {

        console.log(data.join(" "));

    }

    static getStrategyName(strategy) {

        if (strategy instanceof BubbleSort) {
            return "Bubble Sort";
        }

        if (strategy instanceof InsertionSort) {
            return "Insertion Sort";
        }

        if (strategy instanceof QuickSort) {
            return "Quick Sort";
        }

        return "Unknown Strategy";

    }

    static run() {

        const data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3];

        const context = new SortingContext();

        console.log("Original array:");
        this.printArray(data);

        const strategy = context.setSortStrategy(data.length);

        console.log("\nStrategy selected: " + this.getStrategyName(strategy));

        const sortedData = context.sort(data);

        console.log("\nSorted array:");
        this.printArray(sortedData);

    }

}

module.exports = SortApp;