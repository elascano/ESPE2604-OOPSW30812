class IInvestor {

    update(stock) {
        throw new Error("The update() method must be implemented");
    }
}

module.exports = IInvestor;