class IInvestor {

    update(stock, args) {
        throw new Error("update() must be implemented.");
    }

}

module.exports = IInvestor;