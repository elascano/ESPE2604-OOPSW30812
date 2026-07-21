const SortingStrategy = require('./sortingStrategy');

class BubbleSort extends SortingStrategy {
    sort(data) {
        console.log("Sorting using BubbleSort");
        let arr = [...data];
        let n = arr.length;
        for (let i = 0; i < n - 1; i++) {
            for (let j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    let temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}

module.exports = BubbleSort;