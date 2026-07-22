const SortingStrategy = require("./SortingStrategy");

class QuickSort extends SortingStrategy {

    sort(data) {

        return [...data].sort((a, b) => a - b);

    }

}

module.exports = QuickSort;
