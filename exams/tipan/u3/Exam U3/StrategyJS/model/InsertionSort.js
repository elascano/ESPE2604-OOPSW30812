const SortingStrategy = require("./SortingStrategy");

class InsertionSort extends SortingStrategy {

    sort(array) {
        let result = [...array];

        for (let i = 1; i < result.length; i++) {

            let current = result[i];
            let j = i - 1;

            while (j >= 0 && result[j] > current) {
                result[j + 1] = result[j];
                j--;
            }

            result[j + 1] = current;
        }

        return result;
    }
}

module.exports = InsertionSort;