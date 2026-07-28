const SortingStrategy = require("./SortingStrategy");

class BubbleSort extends SortingStrategy {

    sort(array) {
        let result = [...array];

        for (let i = 0; i < result.length - 1; i++) {
            for (let j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    let temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }

        return result;
    }
}

module.exports = BubbleSort;