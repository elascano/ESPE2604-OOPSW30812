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
        if (n > 0 && n < 30) this.ss = new BubbleSort();
        if (n >= 30 && n < 100) this.ss = new InsertionSort();
        if (n >= 100) this.ss = new QuickSort();
        return this.ss;
    }
}

module.exports = SortingContext;