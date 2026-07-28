const BubbleSort = require('./bubbleSort');
const InsertionSort = require('./insertionSort');
const QuickSort = require('./quickSort');

class SortingContext {
    constructor() {
        this.ss = null;
    }

    sort(data) {
        let size = data.length;
        this.ss = this.setSortStrategy(size);
        return this.ss.sort(data);
    }

    setSortStrategy(n) {
        if (n >= 2 && n <= 6) this.ss = new BubbleSort();
        else if (n >= 7 && n <= 10) this.ss = new InsertionSort();
        else if (n >= 11) this.ss = new QuickSort();
        return this.ss;
    }
}

module.exports = SortingContext;