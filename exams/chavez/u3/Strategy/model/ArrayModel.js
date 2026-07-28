class ArrayModel {
    constructor(numbers = []) {
        this.numbers = numbers;
        this.sortedNumbers = [];
        this.algorithm = "";
    }

    getNumbers() {
        return this.numbers;
    }

    setNumbers(numbers) {
        this.numbers = numbers;
    }

    getSortedNumbers() {
        return this.sortedNumbers;
    }

    setSortedNumbers(sortedNumbers) {
        this.sortedNumbers = sortedNumbers;
    }

    getAlgorithm() {
        return this.algorithm;
    }

    setAlgorithm(algorithm) {
        this.algorithm = algorithm;
    }

    getSize() {
        return this.numbers.length;
    }
}

module.exports = ArrayModel;