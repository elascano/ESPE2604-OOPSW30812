class SortingContext {

    constructor(strategy) {
        this.strategy = strategy;
    }

    setStrategy(strategy) {
        this.strategy = strategy;
    }

    execute(array) {
        return this.strategy.sort(array);
    }
}

module.exports = SortingContext;