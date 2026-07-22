const SortingContext = require('./sortingContext');

class SortApp {
    static main() {
        const data = [3, 6, 4, 6, 7, 8, 5, 6, 7, 5, 3, 3];
        const sc = new SortingContext();
        const sortedList = sc.sort(data);

        console.log("Sorted data:", sortedList.join(" "));
    }
}

SortApp.main();