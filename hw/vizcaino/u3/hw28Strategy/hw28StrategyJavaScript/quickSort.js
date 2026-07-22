const SortingStrategy = require('./sortingStrategy');

class QuickSort extends SortingStrategy {
    sort(data) {
        console.log("Sorting using QuickSort");
        let arr = [...data];
        this._quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    _quickSort(arr, low, high) {
        if (low < high) {
            let pi = this._partition(arr, low, high);
            this._quickSort(arr, low, pi - 1);
            this._quickSort(arr, pi + 1, high);
        }
    }

    _partition(arr, low, high) {
        let pivot = arr[high];
        let i = low - 1;
        for (let j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                let temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        let temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

module.exports = QuickSort;