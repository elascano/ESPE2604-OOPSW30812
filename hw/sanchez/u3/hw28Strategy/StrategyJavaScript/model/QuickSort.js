const SortingStrategy = require("./SortingStrategy");

class QuickSort extends SortingStrategy {

    sort(data) {

        let array = [...data];

        this.quickSort(array, 0, array.length - 1);

        return array;

    }

    quickSort(array, low, high) {

        if (low < high) {

            let pivot = this.partition(array, low, high);

            this.quickSort(array, low, pivot - 1);
            this.quickSort(array, pivot + 1, high);

        }

    }

    partition(array, low, high) {

        let pivot = array[high];
        let i = low - 1;

        for (let j = low; j < high; j++) {

            if (array[j] <= pivot) {

                i++;

                let temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }

        }

        let temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;

    }

}

module.exports = QuickSort;